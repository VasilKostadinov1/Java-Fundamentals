
package DEMO.ArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceEqual2_07_LIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 0;
        int maxCount = 0;
        StringBuilder sequence = new StringBuilder();
        StringBuilder maxSequence = new StringBuilder();

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                if (count == 0) {
                    count++;
                    sequence.append(arr[i]).append(" ").append(arr[i + 1]).append(" ");
                } else {
                    count++;
                    sequence.append(arr[i]).append(" ");
                }
            }
            else {
                count = 0;
                sequence = new StringBuilder(); // after we zero the count, we need to zero also and the sequence,
            }                                   // otherwise - will print: 1 1 3 3 2 2 2
            if (count > maxCount) {
                maxSequence = sequence;
                maxCount = count;
            }
        }
        if (maxCount == 0) {
            maxSequence.append("1");
        }
        System.out.println(String.join(" ", maxSequence));
    }
}
