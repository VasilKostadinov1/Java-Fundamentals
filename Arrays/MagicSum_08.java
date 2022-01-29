
package DEMO.ArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int sum = Integer.parseInt(scanner.nextLine());

        for (int index = 0; index <= numbers.length - 1; index++) {
            int number = numbers[index];                     //give me the digit on the current position !!!
            for (int i = index + 1; i <= numbers.length - 1; i++) {   // check all adjacent elements
                int number2 = numbers[i];     // !!! numbers[i]
                if (number + number2 == sum) {
                    System.out.printf("%d %d%n", number, number2);
                }
            }
        }
        /*for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == sum) {
                    System.out.println(numbers[i] + " " + numbers[j]);
                }
            }
        }*/


    }
}
