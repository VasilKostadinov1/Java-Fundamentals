package DEMO.AssociativeArraysExercises;

import java.util.*;

public class StudentAcademy2_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new LinkedHashMap<>(); // students and their grades

        for (int i = 1; i <= n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
                students.get(name).add(grade);
            } else {
                students.get(name).add(grade);
            }
        }
        Map<String, Double> averageGrade = new LinkedHashMap<>(); // !!! new Map for the print

        for (var kvp : students.entrySet()) {
            double average = kvp.getValue().stream().mapToDouble(x -> x).average().getAsDouble();
            if (average >= 4.50) {
                averageGrade.put(kvp.getKey(), average);
            }
        }
        averageGrade.entrySet().stream()
                .sorted((g1, g2) -> g2.getValue().compareTo(g1.getValue()))
                .forEach(grade -> {
                    System.out.printf("%s -> %.2f%n", grade.getKey(), grade.getValue());
                });


    }
}
