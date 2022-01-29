package DEMO.ArraysLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SumEvenNumbers_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int sum = 0;
        /*for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                sum += numbers[i];
            }
        }
        System.out.println(sum);*/

        for (int i : numbers) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);

    }
}
