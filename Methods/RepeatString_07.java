package DEMO.MethodsLab;

import java.util.Scanner;

public class RepeatString_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        repeatString(input, count);
    }

    private static StringBuilder repeatString(String text, int count) {
        StringBuilder sb = new StringBuilder();

        //sb.append(input.repeat(count));
        sb.append(String.valueOf(text).repeat(count));   // String.valueOf is unnecessary, as we are giving input as String
        System.out.println(sb);
        return sb;

    }
}
