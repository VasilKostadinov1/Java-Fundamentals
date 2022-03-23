
package DEMO.EXAMS_Final.Exam5;

import java.util.Scanner;

public class ActivationKey2_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();       // 100/100

        StringBuilder sb = new StringBuilder(message);
        String toChange = "";
        String command = scanner.nextLine();

        while (!command.equals("Generate")) {
            String[] operations = command.split(">>>");
            String commandName = operations[0];
            switch (commandName) {
                case "Contains":
                    String subString = operations[1];
                    if (sb.toString().contains(subString)) {
                        System.out.printf("%s contains %s\n", sb, subString);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip": // Changes the substring between the given indices (the end index is exclusive) to upper or lower case
                    int startIndex = Integer.parseInt(operations[2]);
                    int endIndex = Integer.parseInt(operations[3]);
                    if (operations[1].equals("Upper")) {
                        toChange = sb.substring(startIndex, endIndex).toUpperCase();
                        sb.replace(startIndex, endIndex, toChange);
                    }
                    if (operations[1].equals("Lower")) {
                        toChange = sb.substring(startIndex, endIndex).toLowerCase();
                        sb.replace(startIndex, endIndex, toChange);
                    }
                    System.out.println(sb);
                    break;
                case "Slice": // Deletes the characters between the start and end indices (the end index is exclusive)
                    int startRemoveIndex = Integer.parseInt(operations[1]);
                    int endRemoveIndex = Integer.parseInt(operations[2]);

                    sb.delete(startRemoveIndex, endRemoveIndex);
                    //sb.replace(startRemoveIndex, endRemoveIndex, "");
                    System.out.println(sb);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", sb);


    }
}
