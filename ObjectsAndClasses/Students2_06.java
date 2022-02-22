package DEMO.ObjectsAndClasses_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students2_06 {

    public static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String city;

        public Student(String firstName, String lastName, int age, String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
        }

        public String getFirstName() {
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

            //If you receive a student which already exists (first name and last name should be unique) overwrite the information.
            if (isStudentExits(students, firstName, lastName)) {           // Method 1
                //Student student = getStudent(students,firstName,lastName); // Method 2

                // use Stream instead of the Method 2 !!!
                Student student = students.stream()
                        .filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName))
                        .findFirst().orElse(null);

                //assert student != null;
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setCity(city);

            } else {
                Student student = new Student(firstName, lastName, age, city);
                students.add(student);
            }

            input = scanner.nextLine();
        }
        String filerCity = scanner.nextLine();
        students.stream().filter(e -> e.getCity().equals(filerCity))
                .forEach(entry -> {
                    System.out.printf("%s %s is %d years old%n", entry.getFirstName(), entry.getLastName(), entry.getAge());
                });


    }

    private static Student getStudent(List<Student> students, String firstName, String lastName) {
        Student existingStudent = null;   // !!!
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;  // !!!
            }
        }
        return existingStudent;
    }

    private static boolean isStudentExits(List<Student> students, String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }
}
