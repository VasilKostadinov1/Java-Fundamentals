package DEMO.MethodsExecises;

import java.util.Scanner;

public class PalindromeInteger_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("END")){

            checkForPalindrome(input);
            input = scanner.nextLine();
        }
    }

    private static void checkForPalindrome(String input) {
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        if (input.contentEquals(sb)){
            System.out.printf("true%n");
        }else {
            System.out.printf("false%n");
        }

    }
}
