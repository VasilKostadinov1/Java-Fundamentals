package DEMO.BasicSyntaxLab;

import java.util.Scanner;

public class MultiplicationTable2_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        if (multiplier > 10) {
            System.out.println(n + " X " + multiplier + " = " + n * multiplier);
        } else {
            for (int i = multiplier; i <=10 ; i++) {
                System.out.println(n + " X " + i + " = " + n * i);
            }

        }


    }
}
