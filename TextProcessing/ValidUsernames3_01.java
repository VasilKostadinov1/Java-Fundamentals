package DEMO.TextProcessingExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ValidUsernames3_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // 60/100

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .filter(user->user.matches("[a-zA-Z0-9\\-_]{3,16}")).forEach(System.out::println);
    }

    
}
