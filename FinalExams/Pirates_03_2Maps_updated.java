package DEMO.EXAMS_Final.Exam5;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates_03_2Maps_updated {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> populationMap = new LinkedHashMap<>();
        Map<String, Integer> goldMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Sail")) {
            String[] token = input.split("\\|\\|");   //  !!!!!!
            String city = token[0];
            int population = Integer.parseInt(token[1]);
            int gold = Integer.parseInt(token[2]);

            if (populationMap.containsKey(city)) { // already been received, you have to increase the population and gold
                int newPopulation = populationMap.get(city) + population;
                populationMap.put(city, newPopulation);  // .replace()
            } else {
                populationMap.put(city, population);
            }
            if (goldMap.containsKey(city)) {   // already been received, you have to increase the population and gold
                int newGold = goldMap.get(city) + gold;
                goldMap.put(city, newGold);      // .replace()
            } else {
                goldMap.put(city, gold);
            }
            input = scanner.nextLine();
        }

        String inputAfterSail = scanner.nextLine();
        while (!inputAfterSail.equals("End")) {
            String[] tokenAfterSail = inputAfterSail.split("=>");
            String event = tokenAfterSail[0];
            String town = tokenAfterSail[1];

            switch (event) {
                case "Plunder":
                    int people = Integer.parseInt(tokenAfterSail[2]);
                    int gold2 = Integer.parseInt(tokenAfterSail[3]);
                    // killing the given number of people and stealing the respective amount of gold.
                    int newPopulation = populationMap.get(town) - people;
                    int newGold = goldMap.get(town) - gold2;

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold2, people);

                    if (newPopulation <= 0 || newGold <= 0) {
                        populationMap.remove(town);     // remove it from your collection
                        goldMap.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    } else {
                        populationMap.put(town, newPopulation);
                        goldMap.put(town, newGold);
                    }
                    break;
                case "Prosper":
                    int gold3 = Integer.parseInt(tokenAfterSail[2]);
                    if (gold3 < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        // continue;
                        break;
                    } else {
                        int newGoldReserve = goldMap.get(town) + gold3;
                        goldMap.put(town, newGoldReserve);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n"
                                , gold3, town, newGoldReserve);
                    }
                    break;
            }
            inputAfterSail = scanner.nextLine();
        }
        if (goldMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", goldMap.size());
            goldMap.entrySet().stream()
                    .forEach(kvp -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                            kvp.getKey(), populationMap.get(kvp.getKey()), kvp.getValue()));
        }
    }
}
