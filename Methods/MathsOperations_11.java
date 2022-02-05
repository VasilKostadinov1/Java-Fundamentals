package DEMO.MethodsLab;

import java.util.Scanner;

public class MathsOperations_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int b = Integer.parseInt(scanner.nextLine());

        double finalResult = calculate(a, operator, b);
        System.out.printf("%.0f", finalResult);
    }

    private static double calculate(int a, String operator, int b) {
        double result = 0;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a * 1.0 / b;
                break;
        }
        return result;
    }

}
