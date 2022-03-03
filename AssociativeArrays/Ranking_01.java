package DEMO.AssociativeArraysMoreEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ranking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    // 80/100

        String input = scanner.nextLine();
        Map<String, String> contestValidation = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> userList = new TreeMap<>();

        while (!input.equals("end of contests")) {
            String[] tokens = input.split(":");
            String contest = tokens[0];
            String password = tokens[1];
            contestValidation.put(contest, password);
            input = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();
        while (!secondInput.equals("end of submissions")) {
            String[] tokens2 = secondInput.split("=>");
            String contest = tokens2[0];
            String password = tokens2[1];
            String username = tokens2[2];
            Integer points = Integer.parseInt(tokens2[3]);

            // •	Check if the contest is valid && Check if the password is correct for the given contest
            if (contestValidation.containsKey(contest) && contestValidation.get(contest).equals(password)) {
                userList.putIfAbsent(username, new LinkedHashMap<>());   //Save the user with the contest they take part in
                userList.get(username).putIfAbsent(contest, 0);         //!! add contest, or throws exception
                if (userList.get(username).get(contest) < points) {  //If you receive the same contest and the same user
                    userList.get(username).put(contest, points);    //update the points only if the new ones are more than the older ones.
                }
            }
            secondInput = scanner.nextLine();
        }
        String bestCandidate = "";  // row 42-53 are for the best candidate
        int bestPoints = 0;
        for (var entry : userList.entrySet()) {
            int currentSum = 0;
            for (var integerEntry : entry.getValue().entrySet()) {
                currentSum += integerEntry.getValue();
            }
            if (currentSum > bestPoints) ;
            bestPoints = currentSum;
            bestCandidate = entry.getKey();
        }
        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, bestPoints);
        System.out.println("Ranking: ");
        userList.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .forEach(entry -> {
                        System.out.printf("#  %s -> %d%n", entry.getKey(), entry.getValue());
                    });
        });

    }
}
