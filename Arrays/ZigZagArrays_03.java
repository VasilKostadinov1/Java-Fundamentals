
package DEMO.ArraysExercises;

import java.util.Scanner;

public class ZigZagArrays_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] array1 = new int[n];
        int[] array2 = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");  // "12 34" -> split -> ["12", "34"]   !!!
            int firstNum = Integer.parseInt(input[0]);
            int secondNum = Integer.parseInt(input[1]);

            if ((i + 1) % 2 == 0) {
                array1[i] = secondNum;
                array2[i] = firstNum;
            } else {
                array1[i] = firstNum;
                array2[i] = secondNum;
            }
        }
        for (int first : array1) {
            System.out.print(first + " ");
        }
        System.out.println();
        for (int second : array2) {
            System.out.print(second + " ");
        }


    }
}
