package DEMO.BasicSyntaxMoreExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = new java.util.ArrayList<>(List.of(num1, num2, num3));
        Collections.sort(numbers);
        Collections.reverse(numbers);
        System.out.println(numbers.get(0));
        System.out.println(numbers.get(1));
        System.out.println(numbers.get(2));
        //System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));

        /*int num1=Integer.parseInt(scanner.nextLine());
        int num2=Integer.parseInt(scanner.nextLine());
        int num3=Integer.parseInt(scanner.nextLine());
        int[] numbers = {num1,num2,num3};
        Arrays.sort(numbers);
        System.out.println(numbers[2]);
        System.out.println(numbers[1]);
        System.out.println(numbers[0]); */


    }
}
