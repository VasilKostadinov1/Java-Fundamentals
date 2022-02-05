package DEMO.MethodsLab;

import java.util.Scanner;

public class Calculations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int c = Integer.parseInt(scanner.nextLine());
        int d = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                add(c, d);
                break;
            case "subtract":
                subtract(c, d);
                break;
            case "multiply":
                multiply(c, d);
                break;
            case "divide":
                divide(c, d);
                break;
        }
    }

    private static void divide(int a, int b) {
        System.out.println(a / b);
    }

    private static void multiply(int a, int b) {
        System.out.println(a * b);
    }

    private static void subtract(int a, int b) {
        System.out.println(a - b);
    }

    private static void add(int a, int b) {
        System.out.println(a + b);
    }
}
