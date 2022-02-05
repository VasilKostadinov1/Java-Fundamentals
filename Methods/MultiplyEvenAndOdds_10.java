package DEMO.MethodsLab;

import java.util.Scanner;

public class    MultiplyEvenAndOdds_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Math.abs(Integer.parseInt(scanner.nextLine()));
        System.out.println(multiplyEvenAndOdds(n));
    }

    private static int multiplyEvenAndOdds(int n) {
        int evenSum = getSumEven(n);
        int oddSum = getSumOdd(n);
        return evenSum * oddSum;
    }

    private static int getSumOdd(int n) {
        int oddSum = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 != 0) {
                oddSum += digit;
            }
            n = n / 10;
        }
        return oddSum;

    }

    private static int getSumEven(int n) {
        int evenSum = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 == 0) {
                evenSum += digit;
            }
            n = n / 10;
        }
        return evenSum;
    }

}
