package DEMO.DataTypeAndVariablesExercises;

import java.util.Scanner;

public class SnowBalls_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        double result = 0;
        double maxResult = -200000000.00;
        int maxSnowballSnow = -2000000;
        int maxSnowballTime = -2000000;
        int maxSnowballQuality = -2000000;

        for (int i = 1; i <= N; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            result = Math.pow((1.0 * snowballSnow / snowballTime), snowballQuality);
            // (snowballSnow / snowballTime) ^ snowballQuality
            if (result > maxResult) {
                maxResult = result;
                maxSnowballSnow = snowballSnow;
                maxSnowballTime = snowballTime;
                maxSnowballQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", maxSnowballSnow, maxSnowballTime, maxResult, maxSnowballQuality);
    }
}
