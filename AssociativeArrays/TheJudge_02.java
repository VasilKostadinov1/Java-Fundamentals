package DEMO.AssociativeArraysMoreEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TheJudge_02 {

    public static int count = 1;  // declare it because of the print; count inside lambda should be "final"

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> contestInfo = new LinkedHashMap<>();
        String input;

        while (!"no more time".equals(input = scanner.nextLine())) {
            String[] command = input.split(" -> ");
            String user = command[0];
            String contest = command[1];
            int points = Integer.parseInt(command[2]);
            contestInfo.putIfAbsent(contest, new TreeMap<>());
            contestInfo.get(contest).putIfAbsent(user, 0);
            if (contestInfo.get(contest).get(user) < points) {
                contestInfo.get(contest).put(user, points);
            }
        }
        contestInfo.forEach((key, value) -> {
            System.out.printf("%s: %d participants%n", key, value.size());
            value.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).forEach(v -> {
                System.out.printf("%d. %s <::> %d%n", count, v.getKey(), v.getValue());
                count++;
            });
            count = 1;
        });
        Map<String, Integer> userInfo = new LinkedHashMap<>();
        contestInfo.forEach((key, value) -> value.forEach((key1, value1) -> userInfo.put(key1,
                !userInfo.containsKey(key1) ? value1 : userInfo.get(key1) + value1)));
        System.out.println("Individual standings:");
        userInfo.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.printf("%d. %s -> %d%n", count++, entry.getKey(), entry.getValue()));

    }
}
