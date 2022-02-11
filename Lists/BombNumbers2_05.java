
package DEMO.ListExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers2_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        String[] data = scanner.nextLine().split("\\s+");

        int bombNumber = Integer.parseInt(data[0]);
        int sizeOfBomb = Integer.parseInt(data[1]);

        while (numbers.contains(bombNumber)) {
            int elementIndex = numbers.indexOf(bombNumber);
            int leftInd = Math.max(0, elementIndex - sizeOfBomb);
            int rightInd = Math.min(elementIndex + sizeOfBomb, numbers.size() - 1);

            numbers.subList(leftInd, rightInd + 1).clear();
            /*for (int i = right; i >= left; i--) {
                numbers.remove(i);
            }*/
        }
        System.out.println(numbers.stream().mapToInt(v -> v).sum());
        /*int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);*/


    }
}
