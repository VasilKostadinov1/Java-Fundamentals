package DEMO.DataTypeAndVar_MoreEx;

import java.util.Scanner;

public class FromLeftToTheRight_02_Mid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            int first = Integer.parseInt(tokens[0]);
            int second = Integer.parseInt(tokens[1]);
            int biggest = Math.max(first, second);
            int sum = 0;

            while (biggest != 0) {
                sum += biggest % 10;
                biggest /= 10;
            }
            System.out.println(Math.abs(sum));


        }
    }
}
