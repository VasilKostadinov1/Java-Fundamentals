
package DEMO.EXAMS_Final.Exam2;

import java.util.*;

public class PlantDiscovery2_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());    // 100/100
        Map<String, Integer> rarity = new HashMap<>();
        Map<String, List<Double>> rating = new HashMap<>();    // 1 plant->many ratings

        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split("<->"); //{plant}<->{rarity}
            String plant = tokens[0];
            int rarityPlant = Integer.parseInt(tokens[1]);
            rarity.put(plant, rarityPlant);
            rating.put(plant, new ArrayList<>());
        }
        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String[] command = input.split(": ");         //Rate: {plant} - {rating}
            //String commandName =command[0];
            //String commandAdd =command[1];
            String[] newToken = command[1].split(" - ");  //Rate: {plant} - {rating}
            String name = newToken[0];

            if (!rarity.containsKey(name)) {   // missed this code initially!!! gives 50/100 without it
                System.out.println("error");
                input = scanner.nextLine();
                continue;
            }

            switch (command[0]) {
                case "Rate":        //add the given rating to the plant (store all ratings)
                    double rating2 = Double.parseDouble(newToken[1]);
                    rating.get(name).add(rating2);   // !!required type List
                    break;

                case "Update":   //update the rarity of the plant with the new one
                    int newRarity = Integer.parseInt(newToken[1]);
                    rarity.put(name, newRarity);
                    break;
                case "Reset":    //remove all the ratings of the given plant
                    rating.get(name).clear();
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        /*rarity.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(entry -> {
                    System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue(),
                            rating.get(entry.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0));

                });*/

        //sorted by rarity in descending order. If two or more plants have the same rarity value sort them by average rating in descending order.

        /*rarity.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()
                        .thenComparingDouble(x -> rating.get(x.getKey()).stream()
                                .mapToDouble(Double::doubleValue)
                                .average().orElse(0.0))
                        .reversed())
                .forEach(entry -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                        entry.getKey(), entry.getValue(),
                        rating.get(entry.getKey()).stream()
                                .mapToDouble(Double::doubleValue)
                                .average().orElse(0.0))); */

        rarity.entrySet().stream()
                .sorted((x,y)->y.getValue().compareTo(x.getValue()))
                .forEach(entry -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                        entry.getKey(), entry.getValue(),
                        rating.get(entry.getKey()).stream()
                                .mapToDouble(Double::doubleValue)
                                .average().orElse(0.0)));
    }
}
