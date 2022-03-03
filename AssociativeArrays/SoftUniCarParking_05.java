package DEMO.AssociativeArraysExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniCarParking_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> cars = new LinkedHashMap<>();  // !!! one car per user -> Map <String, String>

        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();
            String[] token = command.split("\\s+");
            String commandName = token[0];
            String userName = token[1];

            if (commandName.equals("register")) {
                String licence = token[2];
                if (!cars.containsKey(userName)) {
                    cars.put(userName,licence);
                    System.out.printf("%s registered %s successfully%n", userName, licence);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", licence);
                }
            } else if (commandName.equals("unregister")) {
                if (!cars.containsKey(userName)) {
                    System.out.printf("ERROR: user %s not found%n", userName);
                } else {
                    cars.remove(userName);
                    System.out.printf("%s unregistered successfully%n", userName);
                }
            }
        }
        cars.forEach((e1, e2) -> System.out.printf("%s => %s%n", e1, e2));



    }
}
