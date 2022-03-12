
package DEMO.TextProcessingExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CaesarCipher_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        for (char s : input.toCharArray()) {
            System.out.printf("%c", s + 3);
        }

        /*String text = scanner.nextLine();
        List<Character> toPrint = new ArrayList<>(); // adding/saving the new chars to List

        for (int i = 0; i < text.length() ; i++) {
            char charToChange = text.charAt(i);
            char toSave = (char)(charToChange+3);

            toPrint.add(toSave);
        }
        for (Character c : toPrint) {
            System.out.print(c);
        } */


    }
}
