package DEMO.ObjectsAndClasses_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students_05 {

    public static class Student {

        private String firstName;
        private String lastName;
        private int age;
        private String city;

        // Auto generate Constructor
        public Student(String firstName, String lastName, int age, String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
        }

        public String getFirstName() {  // Alt + Insert !!! Auto generate Getters & Setters
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String city = tokens[3];
            // ()- needed for the Constructor
            Student student = new Student(firstName, lastName, age, city);
            students.add(student);

            input = scanner.nextLine();
        }
        String filerCity = scanner.nextLine();  // receive city to filter

//        for (Student student : students) {
//            if (student.getCity().equals(filerCity)) {
//                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
//            }
//        }
        students.stream().filter(e -> e.getCity().equals(filerCity))
                .forEach(entry -> {
                    System.out.printf("%s %s is %d years old%n",entry.getFirstName(),entry.getLastName(),entry.getAge());
                });


    }
}
