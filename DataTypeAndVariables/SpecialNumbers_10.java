package DEMO.DataTypeAndVar_Lab;

import java.util.Scanner;

public class SpecialNumbers_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {   // solved in Lab presentation
            int sum = 0;
            int digits = i; //!!! at first digits =i, bur after passing through "digits/10"
                            // digits will be set to 0, and needs to take new value again - going up in the Loop
            while (digits > 0) {
                sum += digits % 10;
                digits = digits / 10;
            }
            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }


        }


    }
}
