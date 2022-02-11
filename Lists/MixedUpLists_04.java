package DEMO.ListExercisesMore;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> finalList = new ArrayList<>();  // we'll add the numbers here

        while (!(firstList.isEmpty() || secondList.isEmpty())) {
            finalList.add(firstList.get(0));
            finalList.add(secondList.get(secondList.size() - 1));
            firstList.remove(0);
            secondList.remove(secondList.size() - 1);
        }
        int min;
        int max;
        if (!firstList.isEmpty()) {
            min = Math.min(firstList.get(firstList.size() - 1), firstList.get(firstList.size() - 2));  // last 2 elements
            max = Math.max(firstList.get(firstList.size() - 1), firstList.get(firstList.size() - 2));  // last 2 elements
        } else {
            min = Math.min(secondList.get(0), secondList.get(1)); // because we start from the end/back, and move towards index 0 and 1
            max = Math.max(secondList.get(0), secondList.get(1));
        }
        for (int i = 0; i < finalList.size(); i++) {
            if (finalList.get(i) >= max || finalList.get(i) <= min) { //These elements will be the range of the elements you need to print
                finalList.remove(i);
                i--; // !!!we want: when we go back to the For cycle, we'll start from zero index again (not first). Debug to see.
            }
        }
        Collections.sort(finalList);
        System.out.println(finalList.toString().replaceAll("[\\[\\],]", "")
                .replaceAll(", ", " "));
    }
}
