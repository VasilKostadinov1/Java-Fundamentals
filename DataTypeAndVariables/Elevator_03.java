package DEMO.DataTypeAndVariablesExercises;

import java.util.Scanner;

public class Elevator_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        int courses = n / capacity;

        if (n % capacity != 0) {
            System.out.println(courses + 1);
        } else {
            System.out.println(courses);
        }

        /*double count = Double.parseDouble(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());

        double courses1 = Math.ceil(count/p);
        System.out.println(courses1); */


    }
}
