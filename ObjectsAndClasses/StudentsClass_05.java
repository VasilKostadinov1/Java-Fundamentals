
package DEMO.ObjectsAndClasses_Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsClass_05 {

    public static class Student {
        private String firstName;
        private String lastName;
        private double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getGrade() {
            return grade;
        }

        public String toString() {
            return String.format("%s %s: %.2f", getFirstName(), getLastName(), getGrade());

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            double grade = Double.parseDouble(input[2]);

            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }
        students.stream().sorted((data1, data2) -> Double.compare(data2.getGrade(), data1.getGrade()))
                .forEach(student -> System.out.println(student.toString()));


    }

}
