package DEMO.DataTypeAndVariablesExercises;

import java.util.Scanner;

public class PokeMon2_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int restN = N;
                             // N - is never changed; changed is only restN !!!
        while (restN >= M) {
            restN -= M;
            count++;
            //IF N becomes equal to EXACTLY 50 % of its original value, you must divide N by Y, if it is POSSIBLE.
            if (restN == N / 2 && Y > 0) {
                restN = restN / Y;
            }
        }
        System.out.println(restN);
        System.out.println(count);
    }
}
