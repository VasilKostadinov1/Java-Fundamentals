
package DEMO.AssociativeArraysExercises;

import java.util.*;
import java.util.stream.Collectors;

public class Orders_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> orders = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("buy")) {
            String[] command = input.split("\\s+");
            String name = command[0];
            double price = Double.parseDouble(command[1]);
            double quantity = Double.parseDouble(command[2]);

            if (!orders.containsKey(name)) {
                orders.put(name, new ArrayList<>());
                orders.get(name).add(price);
                orders.get(name).add(quantity);
            } else {
                orders.get(name).set(0, price);         //if its price is different, replace the price as well.
                double newQuantity = orders.get(name).get(1) + quantity;
                orders.get(name).set(1, newQuantity);   //increase its quantity by the input quantity
            }

            input = scanner.nextLine();
        }
        orders.entrySet().stream()
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue().get(0) * e.getValue().get(1)));


    }


}
