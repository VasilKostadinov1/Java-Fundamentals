
package DEMO.EXAMS.Exams1;

import java.util.Scanner;

public class ComputerStore_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();            // 100/100
        double sum = 0;
        while (!input.equals("special") && !input.equals("regular")) {  // !!! &&
            double number = Double.parseDouble(input);
            if (number < 0) {
                System.out.println("Invalid price!");
            } else {
                sum += number;
            }
            input = scanner.nextLine();
        }
        double taxes = sum * 0.20;
        double totalPrice = sum + taxes;
        if (input.equals("special")) {
            totalPrice = totalPrice * 0.90;
        }
        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", sum);
            System.out.printf("Taxes: %.2f$%n", sum / 5);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalPrice);
        }

    }
}
