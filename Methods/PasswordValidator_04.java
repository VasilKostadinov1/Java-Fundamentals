package DEMO.MethodsExecises;

import java.util.Scanner;

public class PasswordValidator_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean check1 = checkLengthPass(input);
        boolean check2 = checkLettersAndDigits(input);
        boolean check3 = check2Digits(input);

        if (check1 && check2 && check3) {
            System.out.println("Password is valid");
        }
    }

    private static boolean check2Digits(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (Character.isDigit(symbol)) {
                count++;
            }
        }
        if (count<2){
            System.out.println("Password must have at least 2 digits");
            return false;
        }
        return true;
    }

    private static boolean checkLettersAndDigits(String input) {
        //boolean isLetterDigit = false;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetterOrDigit(input.charAt(i))) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }
        return true;
    }

    private static boolean checkLengthPass(String input) {
        if (input.length() >= 6 && input.length() <= 10) {
            return true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
    }


}
