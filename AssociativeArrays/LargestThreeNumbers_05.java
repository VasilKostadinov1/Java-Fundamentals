package DEMO.AssociativeArraysLab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestThreeNumbers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)                     // solution 1
                .sorted((n1, n2) -> n2.compareTo(n1)).limit(3).forEach(e -> System.out.print(e + " "));


        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)                        // solution 2
                .sorted(Comparator.reverseOrder()).limit(3).forEach(e -> System.out.print(e + " "));

        /*List<Integer> sorted = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)   // solution 3
                .sorted((n1,n2)->n2.compareTo(n1)).limit(3).collect(Collectors.toList());
        for (Integer s : sorted) {
            System.out.print(s + " ");
        }  */


    }
}
