package DEMO.AssociativeArraysExercises;

import java.util.*;

public class StudentAcademy_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students= new LinkedHashMap<>(); // students and their grades

        for (int i = 1; i <= n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if (!students.containsKey(name)){
                students.put(name,new ArrayList<>());
            }
            students.get(name).add(grade);
        }
        // Order filtered students by average grade in descending order.
        students.entrySet().stream().filter(e -> getAverage(e.getValue()) >= 4.50)
                .sorted((a, b) -> Double.compare(getAverage(b.getValue()), getAverage(a.getValue())))
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), getAverage(e.getValue())));

    }
    public static double getAverage(List<Double> value) {
        return value.stream().mapToDouble(Double::doubleValue).average().orElseThrow();


    }
}
