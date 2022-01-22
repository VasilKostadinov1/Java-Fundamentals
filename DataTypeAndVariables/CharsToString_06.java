package DEMO.DataTypeAndVar_Lab;

import java.util.Scanner;

public class CharsToString_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*String one = scanner.nextLine();
        String two = scanner.nextLine();
        String three = scanner.nextLine();

        System.out.printf("%s%s%s",one,two,three);*/

        char one = scanner.nextLine().charAt(0);
        char two = scanner.nextLine().charAt(0);
        char three = scanner.nextLine().charAt(0);

        System.out.printf("%c%c%c", one, two, three);
    }
}
