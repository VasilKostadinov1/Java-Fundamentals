
package DEMO.ArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        boolean isFound=false;

        for (int index = 0; index < numbers.length; index++) {
            //int currentNum = numbers[index];
            int leftSum = 0;
            int rightSum = 0;

            for (int leftIndex = 0; leftIndex < index; leftIndex++) {  // left sum : from 0 to my index
                leftSum += numbers[leftIndex];
            }
            for (int rightIndex = index + 1; rightIndex <= numbers.length - 1; rightIndex++) {  // right sum: starts from index+1
                rightSum += numbers[rightIndex];
            }
            if (leftSum == rightSum) {
                System.out.println(index);
                isFound=true;
            }
        }
        if (!isFound){
            System.out.println("no");
        }


    }
}
