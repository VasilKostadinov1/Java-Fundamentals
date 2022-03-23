
package DEMO.EXAMS_Final.Exam4;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordReset_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String message = scanner.nextLine();
        StringBuilder sb = new StringBuilder(message);
        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] command = input.split("\\s+");
            String commandName = command[0];
            switch (commandName) {
                case "TakeOdd":  // Takes only the characters at odd indices and concatenates them
                    StringBuilder newPass = new StringBuilder();
                    for (int i = 1; i < sb.length(); i += 2) {   // odd index - 1,3,...=> i+=2
                        char current = sb.charAt(i);
                        newPass.append(current);
                    }
                    sb = new StringBuilder(newPass);
                    System.out.println(sb);

                    break;
                case "Cut":  // removes its first occurrence
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    sb.replace(index, index + length, "");
                    //sb.delete(index, index + length);
                    System.out.println(sb);

                    break;
                case "Substitute": //  replaces all of its occurrences with the substitute text given
                    String subString = command[1];
                    String substitute = command[2];
                    if (sb.toString().contains(subString)) {
                        String replace = sb.toString().replaceAll(subString, substitute);
                        sb = new StringBuilder(replace);
                        System.out.println(sb);
                    } else {
                        System.out.println("Nothing to replace!");
                    }

                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", sb);
    }
}
