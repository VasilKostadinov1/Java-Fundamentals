package DEMO.AssociativeArraysExercises;

import java.util.*;

public class StudentAcademy3_07_updated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new LinkedHashMap<>(); // students and their grades

        for (int i = 1; i <= n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
            }
            students.get(name).add(grade);
        }
        // Order filtered students by average grade
        students.entrySet().stream().filter(e -> getAverage(e.getValue()) >= 4.50)
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), getAverage(e.getValue())));
    }

    private static double getAverage(List<Double> value) {
        return value.stream().mapToDouble(Double::doubleValue).average().orElseThrow();

    }
}
