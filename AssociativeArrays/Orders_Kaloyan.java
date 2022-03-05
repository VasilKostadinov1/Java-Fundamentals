package DEMO.AssociativeArraysExercises.Kaloyan;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders_Kaloyan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Product> products = new LinkedHashMap<>();
        while (!line.equals("buy")) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            Double price = Double.parseDouble(tokens[1]);
            Double quantity = Double.parseDouble(tokens[2]);
            if (!products.containsKey(name)) {
                products.put(name, new Product(name, price, quantity));  // new ArrayList
            } else {
                products.get(name).setPrice(price);                  // price is different, replace the price as well.
                double currentQ = products.get(name).getQuantity();  //already exists, increases its quantity
                products.get(name).setQuantity(currentQ + quantity);
            }

            line = scanner.nextLine();
        }
        products.forEach((k, v) -> System.out.printf("%s -> %.2f%n", k, v.getPrice() * v.getQuantity()));

    }

    static class Product {
        String name;
        double price;
        double quantity;

        public Product(String name, double price, double quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public double getQuantity() {
            return quantity;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setQuantity(double quantity) {
            this.quantity = quantity;
        }
    }
}
