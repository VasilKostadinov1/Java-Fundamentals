
package DEMO.EXAMS_Final.Exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([=\\/])(?<name>[A-Z][A-Za-z ]{2,})\\1";    // ([=/])

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> destinations = new ArrayList<>();
        int travelPoints = 0;

        while (matcher.find()) {
            String name = matcher.group("name");
            destinations.add(name);

            travelPoints+=name.length();
        }
        System.out.println("Destinations: " + String.join(", ", destinations));
        System.out.printf("Travel Points: %d%n",travelPoints);
        //System.out.println("Travel Points: " + destinations.stream().mapToInt(String::length).sum());

    }
}
