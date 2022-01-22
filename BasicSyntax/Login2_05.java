package DEMO.BasicSyntaxExercise;

import java.util.Scanner;

public class Login2_05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder username = new StringBuilder(scanner.nextLine());
        StringBuilder correctPassword = new StringBuilder(username);
        correctPassword.reverse();
        int count = 1;

        while (count <= 4) {
            String password = scanner.nextLine();
            int comparison = password.compareTo(correctPassword.toString());
            if (0 == comparison) {
                System.out.printf("User %s logged in.", username);
                break;
            } else if (count < 4) {
                System.out.println("Incorrect password. Try again.");
            } else {
                System.out.printf("User %s blocked!", username);
            }
            count++;
        }
    }
}
