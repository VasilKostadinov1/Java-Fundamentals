package DEMO.DataTypeAndVariablesExercises;

import java.util.Scanner;

public class TriplesOfLatinLetters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //read an integer n and print all triples of the first n small Latin letters, ordered alphabetically
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 'a'; i < 'a' + n; i++) {
            for (int j = 'a'; j < 'a' + n; j++) {
                for (int k = 'a'; k < 'a' + n; k++) {
                    System.out.printf("%c%c%c%n",i,j,k);
                }
            }
        }
    }
}
