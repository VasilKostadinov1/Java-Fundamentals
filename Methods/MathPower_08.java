package DEMO.MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        String printResult = new DecimalFormat("0.####").format(mathPower(num, power));
        System.out.println(printResult);
    }

    private static double mathPower(double num, int power) {
        return Math.pow(num, power);
    }
}
