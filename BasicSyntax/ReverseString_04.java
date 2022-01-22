package DEMO.BasicSyntaxMoreExercise;

import java.util.Scanner;

public class ReverseString_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder sb =new StringBuilder(input);
        sb.reverse();
        System.out.println(sb);

        /*for (int i = input.length() - 1; i >= 0; i--) {
            char symbol = input.charAt(i);
            System.out.print(symbol);

        }*/
    }
}
