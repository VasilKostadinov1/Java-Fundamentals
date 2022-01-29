
package DEMO.ArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        boolean isBigger = false;

        for (int index = 0; index <= numbers.length - 1; index++) {
            int number = numbers[index];                   //give me the digit on the current position !!!
            if (index == numbers.length - 1) {               // check if index is last; last index is printed always
                System.out.print(number);
                break;
            }
            for (int i = index + 1; i <= numbers.length - 1; i++) {  // starts from adjacent index
                if (number > numbers[i]) {            // check if current number is greater than all to the right
                    isBigger = true;
                } else {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger) {
                System.out.print(number + " ");
            }

        }


    }

}
