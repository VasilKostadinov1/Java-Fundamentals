
package DEMO.REGEX_MoreExercises;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        Pattern patternRegex = Pattern.compile("[@](?<name>[A-Za-z]+)[^@!:>-]*!(?<behave>[G|N])!");

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char current = input.charAt(i);
                // you must decode by subtracting the key from the value of each character
                char withKeyDecrease = (char) (current - key);
                sb.append(withKeyDecrease);
            }
            Matcher matcher = patternRegex.matcher(sb);
            //List<String> helpers = new LinkedList<>();
            while (matcher.find()) {
                String name = matcher.group("name");
                String behaviour = matcher.group("behave");
                if (behaviour.equals("G")){
                    System.out.println(name);
                }
                //helpers.add(matcher.group("name"));
                //helpers.add(matcher.group("behave"));
            }
            input = scanner.nextLine();
        }



    }
}
