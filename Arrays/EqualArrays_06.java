package DEMO.ArraysLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EqualArrays_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // solved with Lists

        List<Integer> first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        List<Integer> second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        int sum = 0;

        for (int i = 0; i < first.size(); i++) {
            sum += first.get(i);
            if (first.get(i) != second.get(i)) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                return;
            }

        }
        System.out.printf("Arrays are identical. Sum: %d",sum);


    }
}
