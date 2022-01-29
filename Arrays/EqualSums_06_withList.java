
package DEMO.ArraysExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EqualSums_06_withList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        boolean isFound = false;

        for (int i = 0; i < numbers.size(); i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {    // left sum : from 0 to my index excl.
                leftSum += numbers.get(j);
            }
            for (int k = i + 1; k <= numbers.size() - 1; k++) { // right sum: starts from index+1
                rightSum += numbers.get(k);                                       // till last elem. incl.
            }
            if (rightSum == leftSum) {
                System.out.println(i);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("no");
        }
    }
}
