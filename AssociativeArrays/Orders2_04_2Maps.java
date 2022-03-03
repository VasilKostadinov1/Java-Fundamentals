package DEMO.AssociativeArraysExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders2_04_2Maps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Double> priceMap = new LinkedHashMap<>();  // price
        Map<String, Integer> quantityMap = new LinkedHashMap<>();    // quantity

        while (!input.equals("buy")) {
            String[] token = input.split("\\s+");
            String productName = token[0];
            double productPrice = Double.parseDouble(token[1]);
            int productQuantity = Integer.parseInt(token[2]);

            Integer curQuantity = quantityMap.get(productName);
            if (curQuantity == null) {
                curQuantity = 0;
            }
            quantityMap.put(productName, productQuantity + curQuantity);
            priceMap.putIfAbsent(productName, productPrice * productQuantity);
            priceMap.put(productName, productPrice * quantityMap.get(productName));

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Double> entry : priceMap.entrySet()) {
            System.out.printf("%s -> %.2f%n",entry.getKey(),entry.getValue());
        }
    }

    }

