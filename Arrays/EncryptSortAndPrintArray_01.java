
package DEMO.ArraysMoreExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class EncryptSortAndPrintArray_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] input = new String[n];
        int[] sort = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextLine();
        }
        for (int i = 0; i < n; i++) {
            char[] encrypt = input[i].toCharArray();
            int sumVowel = 0;
            int sumConsonant = 0;

            for (int j = 0; j < encrypt.length; j++) {
                if (encrypt[j] == 'a' || encrypt[j] == 'e' || encrypt[j] == 'i' || encrypt[j] == 'o' || encrypt[j] == 'u'
                        || encrypt[j] == 'A' || encrypt[j] == 'E' || encrypt[j] == 'I' || encrypt[j] == 'O' || encrypt[j] == 'U'
                ) {
                    sumVowel = sumVowel + (encrypt[j] * (input[i].length()));
                } else {
                    sumConsonant = sumConsonant + (encrypt[j] / (input[i].length()));
                }
            }
            sort[i] = sumVowel + sumConsonant;
        }
        Arrays.sort(sort);       // !!!!!
        /*for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tempSort;
                if (sort[i] > sort[j]) {
                    tempSort = sort[i];
                    sort[i] = sort[j];
                    sort[j] = tempSort;
                }
            }
        }*/
        for (int i = 0; i < n; i++) {
            System.out.println(sort[i]);
        }
    }
}
