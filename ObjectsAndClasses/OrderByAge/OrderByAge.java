
package DEMO.ObjectsAndClasses_Exercises.OrderByAge_07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {

    public static class Person {
        private String name;
        private String id;
        private int age;

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {  // Setters are not needed in the problem
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
        public String output() {
            return String.format("%s with ID: %s is %d years old.", getName(), getId(), getAge());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String id = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            Person currentPerson = new Person(name, id, age);
            /*currentPerson.setName(name);
            currentPerson.setId(id);
            currentPerson.setAge(age);*/
            persons.add(currentPerson);

            input = scanner.nextLine();
        }
        persons.stream().sorted(Comparator.comparingDouble(Person::getAge))
                .forEach(s-> System.out.println(s.output()));

        //persons.stream().sorted((p1,p2)->Integer.compare(p2.getAge(), p1.getAge()))
          //      .forEach(s-> System.out.println(s.output()));

    }
}
