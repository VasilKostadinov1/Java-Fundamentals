
package DEMO.TextProcessingExercise;

import java.util.Scanner;

public class LettersChangeNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");                 // input [ A12b & s17G]
        double sum = 0;

        for (String s : input) {                                                   // s = A12b ; s = s17G
            double number = Double.parseDouble(s.substring(1, s.length() - 1));    // number = 12.0
            int first = Character.toLowerCase(s.charAt(0)) - 97 + 1;               // its position in the alphabet !!! A = 1; a = 1 !!!
            if (Character.isUpperCase(s.charAt(0))) {                              // upper case
                sum += number / first;                       // divide the number by the letter's position in the alphabet
            } else {
                sum += number * first;
            }
            int last = Character.toLowerCase(s.charAt(s.length() - 1)) - 97 + 1;
            if (Character.isUpperCase(s.charAt(s.length() - 1))) {
                sum -= last;                               // subtract its position from the resulted number
            } else {
                sum += last;
            }
        }
        System.out.printf("%.2f", sum);


    }
}
