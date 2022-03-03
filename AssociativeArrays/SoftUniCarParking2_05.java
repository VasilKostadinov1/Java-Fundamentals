package DEMO.AssociativeArraysExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniCarParking2_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String user = tokens[1];

            switch (command) {
                case "register":
                    String licence = tokens[2];
                    if (!cars.containsKey(user)) {
                        cars.put(user, licence);
                        System.out.printf("%s registered %s successfully%n", user, licence);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n", licence);
                    }
                    break;
                case "unregister":
                    if (!cars.containsKey(user)){{
                        System.out.printf("ERROR: user %s not found%n",user);
                    }
                    }else {
                        cars.remove(user);
                        System.out.printf("%s unregistered successfully%n",user);
                    }
                    break;
            }
        }
        cars.forEach((k,v)-> System.out.printf("%s => %s%n",k,v));
    }
}
