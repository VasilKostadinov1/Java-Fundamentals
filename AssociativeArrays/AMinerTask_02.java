package DEMO.AssociativeArraysExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!resources.containsKey(input)) {
                resources.put(input, quantity);
            } else {
                resources.put(input, resources.get(input) + quantity);  // !!! Value = X.get(key)+value
            }
            //resources.put(input, !resources.containsKey(input) ? quantity: resources.get(input)+quantity);
            input = scanner.nextLine();

        }
        resources.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));

        /*for (Map.Entry<String, Integer> entry : miner.entrySet()) {          // iter+Enter
            System.out.printf("%s -> %d%n",entry.getKey(),entry.getValue());
        }*/

    }
}
