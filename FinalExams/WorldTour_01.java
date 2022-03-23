
package DEMO.EXAMS_Final.Exam2;

import java.util.Scanner;

public class WorldTour_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String initial = scanner.nextLine();
        StringBuilder sb = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] command = input.split(":");
            String commandName = command[0];
            switch (commandName) {
                case "Add Stop":  // Insert the given string at that index
                    int index = Integer.parseInt(command[1]);
                    String string = command[2];
                    if (index >= 0 && index < sb.length()) {  // >=!!!
                        sb.insert(index, string);
                    }
                    System.out.println(sb);
                    break;
                case "Remove Stop": // Remove the elements of the string from the starting index to the end index (inclusive)
                    int start = Integer.parseInt(command[1]);
                    int end = Integer.parseInt(command[2]);
                    if (start >= 0 && end >= 0 && start < sb.length() && end < sb.length()) { // >= !!!
                        sb.replace(start, end + 1, "");
                        //sb.delete(start,end+1);
                    }
                    System.out.println(sb);
                    break;
                case "Switch":   // If the old string is in the initial string, replace it with the new one (all occurrences)
                    String oldString = command[1];
                    String newString = command[2];
                    /*if (sb.toString().contains(oldString)){
                        sb.replace(sb.indexOf(oldString),sb.indexOf(oldString)+oldString.length(),newString);
                    }*/
                    String replaced = sb.toString().replaceAll(oldString, newString);
                    sb = new StringBuilder(replaced);
                    System.out.println(sb);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", sb);


    }
}
