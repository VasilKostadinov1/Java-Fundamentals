package DEMO.DataTypeAndVariablesExercises;

import java.util.Scanner;

public class PokeMon_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());
        int count = 0;
                     //N becomes equal to EXACTLY 50 % of its original value, you must divide N by Y, if it is POSSIBLE.
        int x = N / 2; //middle   10/5=2

        while (N >= M) {
            N -= M;
            count++;
            if (Y > 0 && N % x == 0) {   // 5/5=1
                N = N / Y;               // N =5/2
            }
        }
        System.out.println(N);
        System.out.println(count);



    }
}
