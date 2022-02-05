package DEMO.MethodsExecises;

import java.util.Scanner;

public class VowelsCount_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int print = vowelCount(input);
        System.out.println(print);
    }

    private static int vowelCount(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == 'a' || symbol == 'o' || symbol == 'u' || symbol == 'e' || symbol == 'i' || symbol == 'y' ||
                    symbol == 'A' || symbol == 'O' || symbol == 'U' || symbol == 'E' || symbol == 'I' || symbol == 'Y') {
                count++;
            }
        }
        return count;

    }

}
