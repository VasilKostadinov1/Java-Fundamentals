package DEMO.DataTypeAndVar_MoreEx;

import java.util.Scanner;

public class RefactoringPrimeChecker_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int digit = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i <= digit; i++) {
            boolean prime = true;
            int count = 0;
            for (int j = 2; j <= digit; j++) {
                if (i % j == 0) {
                    count++;
                }
                if (count > 1) {
                    prime = false;
                }
            }
            System.out.println(i + " -> " + prime);
        }
    }
}
