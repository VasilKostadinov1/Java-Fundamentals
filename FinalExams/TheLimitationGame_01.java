
package DEMO.EXAMS_Final.Exam1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TheLimitationGame_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // !!! very difficult

        String message = scanner.nextLine();
        String input = scanner.nextLine();

        StringBuilder sb = new StringBuilder(message);

        while (!input.equals("Decode")) {
            String[] tokens = input.split("\\|+");
            String commandName = tokens[0];
            switch (commandName) {
                case "Move":          // Moves the first n letters to the back of the string
                    int letters = Integer.parseInt(tokens[1]);    //Move 3
                    String subStr = sb.substring(0, letters);     // subStr=llo
                    sb.delete(0, subStr.length());                 //lloHe → Hello
                    sb.append(subStr);

                    break;
                case "Insert":       // Inserts the given value before the given index in the string
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    sb.insert(index, value);
                    break;
                case "ChangeAll":   // Changes all occurrences of the given substring with the replacement text
                    String subString = tokens[1];
                    String replacement = tokens[2];
                    /*while (sb.toString().contains(subString)){  // use while (not if), as there is "zz" as substring!!!
                        sb.replace(sb.indexOf(subString),sb.indexOf(subString)+subString.length(),replacement );
                    }*/
                    String replace = sb.toString().replaceAll(Pattern.quote(subString), replacement);
                    sb = new StringBuilder(replace);
                    /*if (message.contains(subString)) {
                        message = sb.toString().replace(subString, replacement);
                        sb = new StringBuilder(message);
                    }*/
                    break;
            }
            //message = sb.toString();  // !!! otherwise is not manipulating the message
            input = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + sb);
        //System.out.println("The decrypted message is: " + message);

    }
}
