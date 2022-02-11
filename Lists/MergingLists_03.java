
package DEMO.ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        int smallListSize = Math.min(firstList.size(), secondList.size());
        for (int i = 0; i < smallListSize; i++) {
            System.out.print(firstList.get(i) + " " + secondList.get(i) + " ");
              // on last iteration i = 6
        }
        printTheRest(firstList, smallListSize);
        printTheRest(secondList, smallListSize);
    }

    private static void printTheRest(List<Integer> list, int beginIndex) {
        for (int i = beginIndex; i < list.size(); i++) {  // on 1st iteration i = 6
            System.out.print(list.get(i) + " ");
        }
    }
}
