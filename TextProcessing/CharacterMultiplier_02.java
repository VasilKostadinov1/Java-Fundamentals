
package DEMO.TextProcessingExercise;

import java.util.Scanner;

public class CharacterMultiplier_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String[] input = text.split(" ");

        char[] char1 = input[0].toCharArray();
        char[] char2 = input[1].toCharArray();

        int sum = 0;
        for (int i = 0; i < Math.max(char1.length, char2.length); i++) {
            if (i < char1.length && i < char2.length) {
                sum += char1[i] * char2[i];
            } else if (i < char1.length) {    // char1 is longer
                sum += char1[i];
            } else {
                sum += char2[i];
            }
        }
        System.out.println(sum);


    }
}
