package DEMO.AssociativeArraysExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders2_2Maps {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Double> productPrice = new LinkedHashMap<>();
        Map<String, Integer> productQuantity = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] tokens = input.split("\\s+");
            String product = tokens[0];
            double pricePerProduct = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            productPrice.put(product, pricePerProduct);     // price is different, replace the price as well

            if (!productQuantity.containsKey(product)) {
                productQuantity.put(product, quantity);
            } else {                                       // increase its quantity by the input quantity
                productQuantity.put(product, productQuantity.get(product) + quantity);
            }

            input = scanner.nextLine();
        }
        for (var entry : productPrice.entrySet()) {
            //price * quantity
            String productName = entry.getKey();
            double finalSum = entry.getValue() * productQuantity.get(productName);
            System.out.printf("%s -> %.2f%n", entry.getKey(), finalSum);
        }


    }
}
