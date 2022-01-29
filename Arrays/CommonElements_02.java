
package DEMO.ArraysExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CommonElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*String first = scanner.nextLine();    //Hey hello 2 4
        String second = scanner.nextLine();

        String[] firstArray = first.split(" ");   // "Hey", "hello", "4"
        String[] secondArray = second.split(" ");

        for (String wordSecond : secondArray) {
            for (String wordFirst : firstArray) {
                if (wordFirst.equals(wordSecond)){
                    System.out.print(wordFirst+" ");
                }
            }
        }*/
        List<String> numbers1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        List<String> numbers2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        for (String s2 : numbers2) {
            for (String s1 : numbers1) {
                if (s1.equals(s2)) {
                    System.out.print(s1 + " ");
                }
            }
        }


    }
}
