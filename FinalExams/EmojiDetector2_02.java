
package DEMO.EXAMS_Final.Exam5;

import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EmojiDetector2_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        List<String> emojiList = Pattern.compile("(:{2}|\\*{2})[A-Z][a-z]{2,}\\1")
                .matcher(text)
                .results()
                .map(MatchResult::group)           //regex.MatchResult interface represents the result of a match operation.
                .collect(Collectors.toList());

        int coolThreshold = Pattern.compile("\\d")
                .matcher(text)
                .results()
                .mapToInt(matchResult -> Integer.parseInt(matchResult.group()))
                .reduce(1, (a, b) -> a * b);

        System.out.printf("Cool threshold: %d%n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojiList.size());

        //int finalCoolThreshold = coolThreshold;
        emojiList.stream()
                .filter(emoji -> emoji.substring(2, emoji.length() - 2).chars().sum() >= coolThreshold)
                .forEach(System.out::println);

        //.substring(2, emoji.length() - 2) -> exclude 1st and last 2 symbols :: or **

    }
}
