package DEMO.MethodsExecises;

import java.util.Scanner;

public class CharactersInRange_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char start = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);

        printCharsBetweenStartEnd(start, end);
    }

    private static void printCharsBetweenStartEnd(char start, char end) {
        for (int i = Math.min(start, end) + 1; i < Math.max(start, end); i++) {
            System.out.printf("%c ", i);
        }
    }

}
