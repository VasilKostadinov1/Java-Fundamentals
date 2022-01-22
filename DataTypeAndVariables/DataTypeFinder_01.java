package DEMO.DataTypeAndVar_MoreEx;

import java.util.Scanner;

public class DataTypeFinder_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            Scanner scanner2 = new Scanner(input);  // scanner2 = new input
            if (scanner2.hasNextBoolean()) {
                System.out.printf("%s is boolean type%n", input);
            } else if (scanner2.hasNextInt()) {
                System.out.printf("%s is integer type%n", input);
            } else if (input.length() == 1) {
                System.out.printf("%s is character type%n", input);
            } else if (scanner2.hasNextDouble()) {
                System.out.printf("%s is floating point type%n", input);
            } else {
                System.out.printf("%s is string type%n", input);
            }
            input = scanner.nextLine();
        }


    }
}
