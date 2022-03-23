
package DEMO.EXAMS_Final.Exam3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SecretChat3_01_SB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        StringBuilder sb = new StringBuilder(message);   // with String Builder
        String command = scanner.nextLine();

        while (!command.equals("Reveal")) {
            String[] operations = command.split(":\\|:");
            String nameOperations = operations[0];

            switch (nameOperations) {
                case "InsertSpace":           // Inserts a single space at the given index
                    int indexToInsert = Integer.parseInt(operations[1]);
                    sb.insert(indexToInsert, " ");
                    System.out.println(sb);
                    break;
                case "Reverse":    //If the message contains the given substring, !!! cut it out, reverse it and add it at the end
                    String sub = operations[1];
                    if (sb.toString().contains(sub)) {
                        String replace = sb.toString().replaceFirst(Pattern.quote(sub), "");  // cut it "!gnil"
                        sb = new StringBuilder(replace);      // sb after cut part = "hellodar"
                        StringBuilder cutPart = new StringBuilder(sub).reverse();         //reverse it (reverse cut part) = "ling!"
                        sb.append(cutPart);                                               // add it at the end
                        System.out.println(sb);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":    // Changes all occurrences of the given substring with the replacement text.
                    String subToChange = operations[1];
                    String replaceSub = operations[2];
                    String changes = sb.toString().replaceAll(subToChange, replaceSub);
                    sb = new StringBuilder(changes);
                    System.out.println(sb);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", sb);

    }


}
