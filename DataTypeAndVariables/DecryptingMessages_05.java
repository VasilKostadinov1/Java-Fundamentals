package DEMO.DataTypeAndVar_MoreEx;

import java.util.Scanner;

public class DecryptingMessages_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int count = Integer.parseInt(scanner.nextLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            String input = scanner.nextLine();
            char current = input.charAt(0);  // charAt(0) -> input is on separate rows
            char current1 = (char) (current + key);
            sb.append(current1);
        }
        System.out.println(sb);

        /*for (int i = 1; i <= count; i++) {
            System.out.printf("%c", (scanner.nextLine().charAt(0) + key));
        }*/


    }

}
