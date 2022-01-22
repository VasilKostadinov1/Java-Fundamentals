package DEMO.BasicSyntaxExercise;

import java.util.Scanner;

public class Division_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        if (n % 10 == 0) {
            System.out.println("The number is divisible by 10");
            return;
        }
        if (n % 7 == 0) {
            System.out.println("The number is divisible by 7");
        }
        if (n % 2 == 0 && n % 3 == 0) {
            System.out.println("The number is divisible by 6");
            return;
        }
        if (n % 2 == 0) {
            System.out.println("The number is divisible by 2");
            return;
        }
        if (n % 3 == 0) {
            System.out.println("The number is divisible by 3");
        } else {
            System.out.println("Not divisible");
        }


    }
}
