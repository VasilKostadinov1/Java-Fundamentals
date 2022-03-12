
package DEMO.TextProcessingLab;

import java.util.Scanner;

public class RepeatStrings_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] words = input.split("\\s+");

        StringBuilder sb = new StringBuilder();  // Each String is Repeated N Times, Where N is the Length of the String
        /*for (String word : words) {
            int count = word.length();
            for (int i = 0; i < count; i++) {
                sb.append(word);
            }
        }*/
        for (String word : words) {
            sb.append(word.repeat(word.length()));  // .repeat (number of times to repeat)
        }
        System.out.println(sb);
    }
}
