
package DEMO.EXAMS_Final.Exam1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([#\\|])(?<name>[A-Za-z ]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d+)\\1";
        //String regex = "(?<symbols>[#\\|])(?<name>[A-za-z\\s]+)(\\1)(?<date>[0-9]{2}[\\/][0-9]{2}[\\/][0-9]{2})(\\1)(?<calories>[\\d]{1,5})(\\1)";
        //([#|])  = also working

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> output = new ArrayList<>();
        int totalCalories = 0;

        while (matcher.find()) {
            String name = matcher.group("name");
            String expirationData = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));

            totalCalories += calories;
            output.add(String.format("Item: %s, Best before: %s, Nutrition: %d", name, expirationData, calories));
        }
        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);
        for (String s : output) {
            System.out.println(s);
        }
        //output.forEach(System.out::println);

    }
}
