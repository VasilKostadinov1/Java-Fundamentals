package DEMO.AssociativeArraysExercises;

import java.util.*;

public class Courses2_06_updated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Each course has a name and registered students.
        Map<String, List<String>> courses = new LinkedHashMap<>();  // print is the same as in "Forcebook"!!!
        // use LinkedHashMap, otherwise gives 20/100 !!, but correct output
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(" : ");
            String courseName = tokens[0];
            String studentName = tokens[1];
            if (!courses.containsKey(courseName)) {
                courses.put(courseName, new ArrayList<>());
                courses.get(courseName).add(studentName);
            } else {
                courses.get(courseName).add(studentName);
            }
            input = scanner.nextLine();
        }            //print the courses with their names and total registered users
        courses.entrySet().stream()
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
                    List<String> students = entry.getValue();
                    students.forEach(element -> System.out.printf("-- %s%n", element));
                    //entry.getValue().forEach(element -> System.out.printf("-- %s%n", element));
                });
    }
}
