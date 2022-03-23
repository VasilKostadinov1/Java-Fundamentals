
package DEMO.EXAMS.Exams2;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers2_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).sorted(Collections.reverseOrder()).collect(Collectors.toList());

        int totalSum = 0;
        for (Integer currentInteger : numbers) {
            totalSum += currentInteger;
        }
        double averageValue = totalSum * 1.0 / numbers.size();  // find average

        List<Integer> topFiveNumbers = new ArrayList<>();

        for (Integer currentNumber : numbers) {         // find numbers greater than average
            if (currentNumber > averageValue) {
                topFiveNumbers.add(currentNumber);
            }
        }
        if (topFiveNumbers.isEmpty()) {
            System.out.println("No");
        } else if (topFiveNumbers.size() < 5) {
            for (Integer number : topFiveNumbers) {
                System.out.printf("%d ", number);
            }
        } else {
            topFiveNumbers = topFiveNumbers.stream().limit(5).collect(Collectors.toList());
            for (Integer number : topFiveNumbers) {
                System.out.printf("%d ", number);
            }
        }


    }
}
