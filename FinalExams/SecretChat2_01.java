
package DEMO.EXAMS_Final.Exam3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SecretChat2_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();    // without String Builder

        String input = scanner.nextLine();                        //87/100
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
                    if (message.contains(subStr)) {
                        String forReplays = new StringBuilder(subStr).reverse().toString();  // !gnil -> ling!
                        message = message.replace((subStr), "") + forReplays;      //87/100
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
