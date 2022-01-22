package DEMO.DataTypeAndVariablesExercises;

import java.util.Scanner;

public class PokeMon3_10 {

    public static void main(String[] args) {   // by Kaloyan
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());
        double halfN = N * 0.50;
        int targets = 0;
        while (N >= M) {
            N -= M;
            targets++;
            if (N == halfN && Y != 0) { // IF N becomes equal to EXACTLY 50 % of its original value, you must divide N by Y, if it is POSSIBLE
                N /= Y;
            }
        }
        System.out.println(N);
        System.out.println(targets);

    }
}
