package DEMO.MethodsExecises;

import java.util.Scanner;

public class MiddleCharacter_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        middleChar(input);
    }

    private static void middleChar(String input) {
        if (input.length() % 2 == 0) {
            String symbol1 = input.charAt(input.length() / 2 - 1) + "" + input.charAt(input.length() / 2);
            System.out.println(symbol1);
        } else {
            char symbol2 = input.charAt(input.length() / 2);
            System.out.print(symbol2);
        }
    }
}
