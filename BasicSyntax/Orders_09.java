package DEMO.BasicSyntaxExercise;

import java.util.Scanner;

public class Orders_09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double sum=0;

        for (int i = 1; i <= n; i++) {
            double price = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());
            double total = price * days * capsulesCount;
            System.out.printf("The price for the coffee is: $%.2f%n", total);
            sum+=total;
        }
        System.out.printf("Total: $%.2f",sum);

    }
}
