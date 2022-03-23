
package DEMO.EXAMS_Final.Exam3;

import java.util.Scanner;

public class SecretChat_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String[] command = input.split(":\\|:");
            switch (command[0]) {
                case "InsertSpace":                     // Inserts a single space at the given index.
                    int index = Integer.parseInt(command[1]);
                    String newString = message.substring(0, index) + " " + message.substring(index);
                    message = newString;
                    System.out.println(message);
                    break;
                case "Reverse":  //cut it out, reverse it and add it at the end
                    String subStr = command[1];
                    StringBuilder sb = new StringBuilder(subStr);

                    if (message.contains(subStr)) {
                        subStr = sb.reverse().toString();    // 1. reverse it

                        int startIndex = message.indexOf(command[1]);
                        int endIndex = startIndex + command[1].length();

                        StringBuilder updatedSB = new StringBuilder(message);

                        updatedSB.delete(startIndex, endIndex);          // 2. cut it
                        message = updatedSB.append(subStr).toString();   // 3. put it to the end
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":  // Changes all occurrences of the given substring with the replacement text.
                    String subString = command[1];
                    String replacement = command[2];
                    message = message.replaceAll(subString, replacement);

                    System.out.println(message);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);


    }
}
