package DEMO.TextProcessingExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ValidUsernames2_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        //List<String> input = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        List<String> validUsername = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {     // input.size
            String current = input[i];               // input.get(i)
            // only letters, numbers, hyphens and underscores
            if (current.length() > 3 && current.length() < 16 && current.matches("[a-zA-Z0-9\\-_]+")) {
                validUsername.add(current);
            }
        }
        for (String s : validUsername) {
            System.out.println(s);
        }
    }
}
