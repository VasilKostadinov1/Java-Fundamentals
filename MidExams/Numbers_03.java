
package DEMO.EXAMS.Exams2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        //print the top 5 numbers greater than the average value in the sequence, sorted in descending order.

        List<Integer> newList = numbers.stream()
                .filter(e -> e > numbers.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0))
                .sorted(Comparator.reverseOrder()).limit(5).collect(Collectors.toList());

        if (newList.isEmpty()) {
            System.out.println("No");
        } else {
            System.out.print(Arrays.toString(new List[]{newList})
                    .replaceAll("[\\[\\]]", "").replaceAll(", ", " "));
        }


    }
}
