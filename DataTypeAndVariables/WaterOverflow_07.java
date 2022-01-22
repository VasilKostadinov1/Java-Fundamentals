package DEMO.DataTypeAndVariablesExercises;

import java.util.Scanner;

public class WaterOverflow_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (capacity - quantity < 0) {
                System.out.println("Insufficient capacity!");
                continue;
            }
            capacity -= quantity;
            sum += quantity;
        }
        System.out.println(sum);
    }
}
