
package DEMO.ArraysExercises;

import java.util.Scanner;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] people = new int[n];
        int sum = 0;

        for (int i = 0; i <= people.length - 1; i++) {    // iterating the indexes
            people[i] = Integer.parseInt(scanner.nextLine());
        }
        for (int person : people) {               // iterating elements
            System.out.printf("%d ", person);
            sum += person;
        }
        System.out.println();
        System.out.println(sum);


    }
}
