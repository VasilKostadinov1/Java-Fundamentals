
package DEMO.TextProcessingExercise;

import java.util.Scanner;

public class ReplaceRepeatingChars_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(input);

        for (int i = 0; i < sb.length() - 1; i++) {  // "-1", as we can't compare last index with anything
            char symbol = sb.charAt(i);
            char symbol2 = sb.charAt(i + 1);
            if (symbol == symbol2) {
                sb.deleteCharAt(i + 1);
                i--;  // if we delete 2 adjacent indexes, we need to start from beginning
            }
        }
        System.out.println(sb);

    }
}
