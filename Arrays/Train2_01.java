
package DEMO.ArraysExercises;

import java.util.Scanner;

public class Train2_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] train = new int[n];
        int sum = 0;

        for (int i = 0; i < train.length; i++) {
            train[i] = Integer.parseInt(scanner.nextLine());
            sum += train[i];
            System.out.print(train[i] + " ");
        }
        System.out.println("\n" + sum);
    }
}
