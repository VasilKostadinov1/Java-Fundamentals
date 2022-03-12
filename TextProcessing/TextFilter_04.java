
package DEMO.TextProcessingLab;

import java.util.Arrays;
import java.util.Scanner;

public class TextFilter_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String input = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            input = input.replaceAll(bannedWord, new String(new char[bannedWord.length()]).replace('\0', '*'));
        }
        System.out.println(input);

    }
}
