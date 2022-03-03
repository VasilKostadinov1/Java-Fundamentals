package DEMO.AssociativeArraysLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFilter_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  //Read an array of strings, take only words which length is even

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(e -> e.length() % 2 == 0).forEach(System.out::println);        // List solution 1.

        /*String[] words = Arrays.stream(scanner.nextLine().split(" "))                // Array solution 2.
                .filter(i -> i.length() % 2 == 0).toArray(String[]::new);
        for (String word : words) {
            System.out.println(word);
        }*/


        /*List<String> sorted =Arrays.stream(scanner.nextLine().split("\\s+"))        //  List solution 3.
                .filter(e -> e.length() % 2 == 0).collect(Collectors.toList());
        System.out.println(sorted.toString().replaceAll("[\\[\\],]", ""));  */


    }
}
