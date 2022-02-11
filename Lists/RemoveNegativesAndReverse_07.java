
package DEMO.ListsLab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        numbers = removeNegativeNumbers(numbers);

        if (numbers.isEmpty()) {
            System.out.println("empty");
        } else {
            Collections.reverse(numbers);
            System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
        }
    }

    private static List<Integer> removeNegativeNumbers(List<Integer> list) {
        list.removeIf(e -> e < 0);
        /*for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            if (element < 0) {
                list.remove(i);
                i--;   // !!! if we remove a number in a Loop, we have to go back with 1 index !!
            }
        }*/
        return list;
    }
}
