package DEMO.DataTypeAndVariablesExercises;

import java.util.Scanner;

public class SpiceMustFlow_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yieldTotal = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int sum = 0;

        while (yieldTotal >= 100) {
            int consumed = yieldTotal - 26;   //The mining crew consumes 26 spice every day
            sum += consumed;
            yieldTotal -= 10;
            days++;
        }
        System.out.println(days);
        if (sum >= 26) {
            sum -= 26;
        }
        System.out.println(sum); //and an additional 26 after the mine has been exhausted
    }
}
