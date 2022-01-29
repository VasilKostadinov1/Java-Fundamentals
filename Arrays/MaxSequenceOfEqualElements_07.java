
package DEMO.ArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))   // 2 1 1 2 3 3 2 2 2 1
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int maxCount = 0;
        int digit = 0;    //we'll keep the number with the longest sequence here
        int counter = 1;  // when we find initially 2 equal elements, their sum should jump to 2 !!!

        for (int i = 1; i <= numbers.length - 1; i++) {  // start from second number, and compare with num to the left
            if (numbers[i] == numbers[i - 1]) {
                counter++;

                if (counter > maxCount) {  // If several longest sequences exist, print the leftmost one.
                    maxCount = counter;
                    digit = numbers[i];
                }
            } else
                counter = 1;
        }
        for (int i = 0; i < maxCount; i++) {
            System.out.print(digit + " ");
        }

    }
}
