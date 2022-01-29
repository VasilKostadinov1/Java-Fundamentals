package DEMO.ArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum2_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == n) {
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }
    }
}
