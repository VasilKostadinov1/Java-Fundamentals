
package DEMO.EXAMS_Final.Exam5;

import java.util.*;

public class Pirates_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Integer>> pirates = new TreeMap<>();

        while (!input.equals("Sail")) {
            String[] tokens = input.split("\\|\\|");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);
            if (!pirates.containsKey(city)) {
                pirates.put(city, new ArrayList<>());
                pirates.get(city).add(population);     // 0 index - people
                pirates.get(city).add(gold);           // 1 index - gold
            } else {
                int populationReal = pirates.get(city).get(0);
                populationReal += population;
                int goldReal = pirates.get(city).get(1);
                goldReal += gold;
                pirates.get(city).set(0, populationReal); // population = 0
                pirates.get(city).set(1, goldReal);       // gold = 1
            }
           /* pirates.putIfAbsent(city, new ArrayList<>());
            int populationReal = pirates.get(city).get(0);
            populationReal += population;
            int goldReal = pirates.get(city).get(1);
            goldReal += gold;
            pirates.get(city).set(0, populationReal);
            pirates.get(city).set(1, goldReal); */
            input = scanner.nextLine();
        }
        String input2 = scanner.nextLine();
        while (!input2.equals("End")) {
            String[] tokens2 = input2.split("=>");
            String commandName = tokens2[0];
            String city = tokens2[1];
            switch (commandName) {
                case "Plunder":
                    int population = Integer.parseInt(tokens2[2]);
                    int gold = Integer.parseInt(tokens2[3]);
                    int populationReal = pirates.get(city).get(0);
                    int goldReal = pirates.get(city).get(1);

                    populationReal -= population;    // killing the given number of people      !!   -=
                    goldReal -= gold;                // stealing the respective amount of gold  !!   -=
                    pirates.get(city).set(0, populationReal);
                    pirates.get(city).set(1, goldReal);

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, gold, population);
                    if (pirates.get(city).get(0) == 0 || pirates.get(city).get(1) == 0) {  // !! .get(0) or get(1)
                        pirates.remove(city);
                        System.out.printf("%s has been wiped off the map!%n", city);
                    }
                    break;
                case "Prosper":
                    int goldProsper = Integer.parseInt(tokens2[2]);
                    int goldCurrent = pirates.get(city).get(1);   // before prosper
                    if (goldProsper < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        goldCurrent += goldProsper;  //increasing its treasury by the given amount of gold.; after prosper
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldProsper, city, goldCurrent);
                    }
                    pirates.get(city).set(1, goldCurrent);
                    break;
            }
            input2 = scanner.nextLine();
        }
        if (pirates.isEmpty()){
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
        // print is similar to "Need for Speed"
        else { // sorted by their gold in descending order
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",pirates.size());
            pirates.entrySet().stream()
                    .sorted((s, t) -> t.getValue().get(1) - s.getValue().get(1))     // sorted by their gold in descending order
                    .forEach(kvp -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                            kvp.getKey(), kvp.getValue().get(0), kvp.getValue().get(1)));
        }



    }
}
