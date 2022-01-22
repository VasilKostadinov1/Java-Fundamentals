package DEMO.BasicSyntaxExercise;

import java.util.Scanner;

public class Login_05 {

    public static void main(String[] args) {          //  50/100
        Scanner scanner = new Scanner(System.in);

        String pass = scanner.nextLine();
        StringBuilder sb = new StringBuilder(pass);
        sb.reverse();
        boolean isValid = false;
        int count = 1;

        for (int i = 1; i <= 4; i++) {
            String input = scanner.nextLine();
            if (input.equals(sb.toString())) {
                System.out.printf("User %s logged in.", pass);
                isValid = true;
                break;    // ! for 100/100
            } else {
                if (count < 4) {
                    System.out.println("Incorrect password. Try again.");
                }
            }
            count++;
        }
        if (!isValid) {
            System.out.printf("User %s blocked!", pass);
        }


    }
}
