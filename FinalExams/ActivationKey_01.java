
package DEMO.EXAMS_Final.Exam5;

import java.util.Scanner;

public class ActivationKey_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();            //57/100 ??? Why???
        StringBuilder sb = new StringBuilder(message);
        String input = scanner.nextLine();
        String toChange = "";

        while (!input.equals("Generate")) {
            String[] command = input.split(">>>");
            String commandName = command[0];
            switch (commandName) {
                case "Contains":
                    String subStr = command[1];
                    if (sb.toString().contains(subStr)) {
                        System.out.printf("%s contains %s", sb, subStr);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upLow = command[1];
                    int startI = Integer.parseInt(command[2]);
                    int endI = Integer.parseInt(command[3]);
                    if (command[1].equals("Upper")) {
                        toChange = sb.substring(startI, endI).toUpperCase();
                    } else if (command[1].equals("Lower")){
                        toChange = sb.toString().substring(startI, endI).toLowerCase();
                    }
                    sb.replace(startI, endI, toChange);
                    System.out.println(sb);
                    break;
                case "Slice":
                    int start = Integer.parseInt(command[1]);
                    int end = Integer.parseInt(command[2]);
                    //sb.replace(start, end, "");
                    sb.delete(start,end);
                    System.out.println(sb);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", sb);



    }
}
