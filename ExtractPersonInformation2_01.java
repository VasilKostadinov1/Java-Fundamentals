package DEMO.TextProcessingMoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInformation2_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String text = scanner.nextLine();
            String regexName = "@(?<name>[A-Za-z]+)\\|";
            String regexAge = "#(?<age>[0-9]+)\\*";

            Pattern patternName = Pattern.compile(regexName);
            Matcher matcherName = patternName.matcher(text);
            Pattern patternAge = Pattern.compile(regexAge);
            Matcher matcherAge = patternAge.matcher(text);

            while (matcherName.find() && matcherAge.find()) {
                String name = matcherName.group("name");
                String age = matcherAge.group("age");

                System.out.printf("%s is %s years old.%n", name, age);
            }

        }
    }
}

