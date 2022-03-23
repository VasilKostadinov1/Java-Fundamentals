
package DEMO.EXAMS_Final.Exam3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([@#])(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";    // ([@#]) == [@|#]

        //([@#])(?<first>[A-Za-z]{3,})\\1(?<second>[A-Za-z]{3,})\\1" -> \\1 :will give pairs: car<=>rac
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> mirror = new ArrayList<>();
        int count = 0;

        while (matcher.find()) {
            count++;
            String name1 = matcher.group("first");   // pool
            String name2 = matcher.group("second");  // loop
            String name2Reversed = new StringBuilder(name2).reverse().toString();  //pool
            if (name1.equals(name2Reversed)) {
                mirror.add(name1 + " <=> " + name2);
            }
        }
        if (count == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", count);
        }
        if (mirror.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.printf("%s", String.join(", ", mirror));
        }

    }
}
