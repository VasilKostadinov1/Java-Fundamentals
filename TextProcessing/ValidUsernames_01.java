
package DEMO.TextProcessingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ValidUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] text = input.split(",\\s");


        for (String s : text) {
            boolean isValid = true;   // !!! if boolean declared out of the for, is not working correct ??
            if (s.length() < 3 || s.length() > 16) {
                isValid = false;
            } else {
                for (int i = 0; i < s.length(); i++) {
                    char symbol = s.charAt(i);
                    if (!Character.isLetterOrDigit(symbol) && s.charAt(i) != '-' && s.charAt(i) != '_') {
                        isValid = false;
                        break;
                    }
                }
            }
            if (isValid) {
                System.out.println(s);
            }
        }

    }
}

