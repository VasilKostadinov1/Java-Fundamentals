package DEMO.MethodsExecises;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestOfThreeNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int one = Integer.parseInt(scanner.nextLine());
        int two = Integer.parseInt(scanner.nextLine());
        int three = Integer.parseInt(scanner.nextLine());

        System.out.println(smallestOfThree(one, two, three));
    }

    private static int smallestOfThree(int one, int two, int three) {
        int compare = Math.min(one, two);
        return Math.min(compare, three);

        //int comp2 = Math.min(compare, three);
        //return comp2;
    }
    /*private static int getSmallestNumber(int num1, int num2, int num3) {
        int[] numbers = {num1, num2, num3};
        Arrays.sort(numbers);
        return numbers[0];
    }*/
}
