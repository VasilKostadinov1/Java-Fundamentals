
package DEMO.TextProcessingExercise;

import java.util.Scanner;

public class StringExplosion_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(input);
        int power = 0;

        for (int i = 0; i < sb.length(); i++) {
            char symbol = sb.charAt(i);
            if (symbol == '>') {             // string valueOf() method converts different types of values into string.
                                             // string valueOf() - acts like Concatenation
                power += Integer.parseInt(String.valueOf((sb.charAt(i + 1))));

            } else if (power > 0 && sb.charAt(i) != '>') {
                sb.deleteCharAt(i);
                power--;
                i--;
            }
        }
        System.out.println(sb);

    }
}
