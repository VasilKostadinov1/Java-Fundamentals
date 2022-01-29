
package DEMO.ArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory_09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        int[] bestDNA = new int[length];    // for the print
        String input = scanner.nextLine();
        int sample = 1;    // for the print

        int bestSample = 0;
        int maxSum = 0;
        int bestIndex = 0;
        int maxSequenceLength = 0;
        while (!input.equals("Clone them!")) {
            int[] dna = Arrays
                    .stream(input.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int currentSum = 0;
            int sequenceLength = 1;     // counter begins from 1 !! as when we find 2 equal digits, their count should go to two in the beginning
            int currentIndex = 0;       // leftmost starting index
            for (int i = 0; i < dna.length; i++) {
                currentSum += dna[i];

                if (i != dna.length - 1) {  // without it throws exception; we can't compare last index with next
                    if (dna[i] == 1 && dna[i + 1] == 1) {
                        sequenceLength++;
                        currentIndex = i + 1;  // move to next index
                    }
                }
            }     // now check the 3 conditions
            if (sequenceLength > maxSequenceLength ||                                         // 1.
                    (sequenceLength == maxSequenceLength && currentIndex < bestIndex) ||      // 2. leftmost starting index -> ...<..
                    (sequenceLength == maxSequenceLength && currentIndex == bestIndex && currentSum > maxSum)) {   // 3. max sum
                maxSequenceLength = sequenceLength;
                bestIndex = currentIndex;     //leftmost starting index
                maxSum = currentSum;
                bestSample = sample;

                for (int i = 0; i < length; i++) {   // for the print
                    bestDNA[i] = dna[i];
                }
            }
            input = scanner.nextLine();
            sample++;   // for the print
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSample, maxSum);
        for (int i : bestDNA) {
            System.out.print(i + " ");
        }
    }
}
