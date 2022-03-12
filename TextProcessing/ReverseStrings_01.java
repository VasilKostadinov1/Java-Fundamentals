
package DEMO.TextProcessingLab;

import java.util.Scanner;

public class ReverseStrings_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*String line = scanner.nextLine();      // solution as in Lab
        while (!line.equals("end")) {
            StringBuilder reversed = new StringBuilder();
            for (int i = line.length() - 1; i >= 0; i--) {
                reversed.append(line.charAt(i));
            }
            System.out.printf("%s = %s%n", line, reversed.toString());
            line = scanner.nextLine();
        }*/

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            StringBuilder sb = new StringBuilder(input);   // sb inside the loop!!!
            System.out.printf("%s = %s%n", input, sb.reverse());

            input = scanner.nextLine();
        }


    }
}
