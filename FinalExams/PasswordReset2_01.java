
package DEMO.EXAMS_Final.Exam4;

import java.util.Scanner;

public class PasswordReset2_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Done")) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "TakeOdd":
                    String newPassword = "";
                    for (int i = 1; i < password.length(); i += 2) {
                        newPassword += password.charAt(i);
                    }
                    password = newPassword;
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    String first = password.substring(0, index);
                    String second = password.substring(index + length);
                    password = first + second;
                    System.out.println(password);

                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[1];
                    if (password.contains(substring)) {
                        password = password.replaceAll(substring, substitute);
                        System.out.println(password);
                    }else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", password);

    }
}
