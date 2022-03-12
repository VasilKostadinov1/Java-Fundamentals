
package DEMO.TextProcessingMoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInformation_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String text = scanner.nextLine();

            String name = text.substring(text.indexOf("@") + 1, text.indexOf("|"));
            String age = text.substring(text.indexOf("#") + 1, text.indexOf("*"));
            System.out.printf("%s is %s years old.%n", name, age);

        }
    }
}
