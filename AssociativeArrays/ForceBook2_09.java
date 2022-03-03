package DEMO.AssociativeArraysExercises;

import java.util.*;

public class ForceBook2_09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> forceInformation = new LinkedHashMap<>();
        String input;

        while (!"Lumpawaroo".equals(input = scanner.nextLine())) {
            if (input.contains("|")) {
                String[] command = input.split("\\s\\|\\s+");
                boolean check = forceInformation.entrySet().stream().anyMatch(current -> current.getValue().contains(command[1]));
                if (!check) {
                    forceInformation.putIfAbsent(command[0], new ArrayList<>());
                    forceInformation.get(command[0]).add(command[1]);
                }
            } else {
                String[] command = input.split("\\s->\\s+");
                forceInformation.entrySet().stream().filter(current -> current.getValue().contains(command[0]))
                        .findFirst().ifPresent(current -> forceInformation.get(current.getKey()).remove(command[0]));
                forceInformation.putIfAbsent(command[1], new ArrayList<>());
                forceInformation.get(command[1]).add(command[0]);
                System.out.printf("%s joins the %s side!%n", command[0], command[1]);
            }
        }
        //print all the force users.
        forceInformation.entrySet().stream().filter(users -> users.getValue().size() > 0)
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(s -> {
                    System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());
                    s.getValue().stream().sorted(String::compareTo).forEach(person -> System.out.printf("! %s%n", person));
                });
    }
}

