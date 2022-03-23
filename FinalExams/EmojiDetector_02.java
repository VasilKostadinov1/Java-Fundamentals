
package DEMO.EXAMS_Final.Exam5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        // regex = ([*:]{2})(?<emoji>[A-Z][a-z]{2,})\1

        String regexDigit = "\\d";
        Pattern patternDigit = Pattern.compile(regexDigit);
        Matcher matcherDigit = patternDigit.matcher(input);

        int coolThreshold = 1;
        // You have to get your cool threshold. It is obtained by multiplying all the digits found in the input
        while (matcherDigit.find()) {
            int digit = Integer.parseInt(matcherDigit.group());
            coolThreshold *=digit ;  // by multiplying
        }
        System.out.println("Cool threshold: " + coolThreshold);

        String regexEmojis = "([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1"; // 1st & 2nd Capture group
        Pattern patternEmojis = Pattern.compile(regexEmojis);
        Matcher matcherEmojis = patternEmojis.matcher(input);

        List<String> listCoolOnes = new ArrayList<>();
        int counterEmojis = 0;

        while (matcherEmojis.find()) {
            counterEmojis++;
            String emoji = matcherEmojis.group();        // ::Smiley::
            String textEmoji = matcherEmojis.group(2);   // Smiley
            int coolThresholdEmoji = 0;

            //The coolness of the emoji is determined by summing all the ASCII values of all letters in the emoji.
            for (int i = 0; i < textEmoji.length(); i++) {
                int ascii = textEmoji.charAt(i);     // !!! int
                coolThresholdEmoji += ascii;
            }
            if (coolThresholdEmoji >= coolThreshold) {   // .....>= 540
                listCoolOnes.add(emoji);
            }
        }
        System.out.printf("%d emojis found in the text. The cool ones are:%n", counterEmojis);

        if (!listCoolOnes.isEmpty()) {
            listCoolOnes.forEach(System.out::println);
        }





    }

}

