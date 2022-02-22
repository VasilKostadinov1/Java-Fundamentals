
package DEMO.ObjectsAndClasses_Exercises.OpinionPoll_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            people.add(person);
        }
        people.stream().filter(p->p.getAge()>30)
                .sorted((p1,p2)-> p1.getName().compareTo(p2.getName()))
                .forEach(entry-> System.out.printf("%s - %d%n",entry.getName(),entry.getAge()));

    }
}
