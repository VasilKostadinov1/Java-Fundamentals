package DEMO.TextProcessingExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceRepeatingChars2_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();
        List<Character> toPrint = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (i == input.length() - 1) {
                break;
            }
            char current = input.charAt(i);
            char currentTwo = input.charAt(i + 1);
            if (!toPrint.contains(current)) {
                toPrint.add(current);        // adding to the List
            }
            if (current != currentTwo) {
                toPrint.add(currentTwo);     // adding to the List
            }
        }
        for (Character c : toPrint) {
            System.out.print(c);
        }
    }
}
