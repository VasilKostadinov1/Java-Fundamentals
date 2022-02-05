package DEMO.MethodsExecises;

import java.util.Scanner;

public class AddAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int sumResult = sumMethod(a, b);
        System.out.println(finalResult(sumResult, c));

    }

    private static int finalResult(int sumResult, int c) {
        return sumResult - c;
    }

    private static int sumMethod(int a, int b) {
        return a + b;
    }
}
