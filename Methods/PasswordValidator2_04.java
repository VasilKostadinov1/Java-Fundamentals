package DEMO.MethodsExecises;

import java.util.Scanner;

public class PasswordValidator2_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        checkPassword(input);
    }

    private static void checkPassword(String input) {
        boolean check1 = false;                                    // 1.
        if (input.length() >= 6 && input.length() <= 10) {
            check1 = true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
        }

        boolean check2 = true;                                     // 2.
        for (int i = 0; i < input.length(); i++) {
            String extract = input.replaceAll("[^a-zA-Z^0-9]", "");
            if (!input.equals(extract)) {
                check2 = false;
            }
        }
        if (!check2) {
            System.out.println("Password must consist only of letters and digits");
        }

        boolean check3 = true;                                       // 3.
        String onlyNum = input.replaceAll("[^0-9]", "");
        int count = 0;
        for (int i = 0; i < onlyNum.length(); i++) {
            count++;
        }
        check3 = count >= 2;
        if (!check3) {
            System.out.println("Password must have at least 2 digits");
        }
        if (check1 && check2 && check3) {
            System.out.println("Password is valid");
        }

    }
}
