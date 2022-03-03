package DEMO.AssociativeArraysExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults2_10_update {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> statisticsPoints = new LinkedHashMap<>();  // Linked - in order of appearance !!
        Map<String, Integer> statisticsLanguage = new LinkedHashMap<>();
        String input;

        while (!"exam finished".equals(input = scanner.nextLine())) {
            String[] command = input.split("-");
            if (command[1].equals("banned")) {
                statisticsPoints.remove(command[0]);
            } else {
                statisticsLanguage.put(command[1], !statisticsLanguage.containsKey(command[1]) ? 1 :
                        statisticsLanguage.get(command[1]) + 1);
                statisticsPoints.putIfAbsent(command[0], 0);
                if (statisticsPoints.get(command[0]) < Integer.parseInt(command[2])) {
                    statisticsPoints.put(command[0], Integer.parseInt(command[2]));
                }
            }
        }
        // print in order of appearance -> Linked Hash Map
        System.out.println("Results:");
        statisticsPoints.entrySet().stream()
                .forEach(e -> System.out.printf("%s | %d%n", e.getKey(), e.getValue()));
        System.out.println("Submissions:");
        statisticsLanguage.entrySet().stream()
                .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));
    }



}

