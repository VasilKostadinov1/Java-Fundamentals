
package DEMO.EXAMS.Exams6;

import java.util.Scanner;

public class BlackFlag_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double dailyPlunder = Double.parseDouble(scanner.nextLine());
        double expectedPlunder = Integer.parseInt(scanner.nextLine());
        double totalPlunder = 0;

        for (int i = 1; i <= days; i++) {
            totalPlunder += dailyPlunder;
            if (i % 3 == 0) {        // every third day - add additional plunder to their total gain, which is 50% of the daily plunder
                totalPlunder +=  dailyPlunder / 2;
            }
            if (i % 5 == 0) {     // Every fifth day - they lose 30% of their total plunder.
                totalPlunder = totalPlunder * 0.70;
            }
        }
        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            double percent = (totalPlunder / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", percent);
        }

    }
}
