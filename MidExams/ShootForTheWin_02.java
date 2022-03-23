
package DEMO.EXAMS.Exams3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // Similar to "Pokemon don't go"

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        String input = scanner.nextLine();
        int count = 0;
        int oldValue = 0;

        while (!input.equals("End")) {
            int newIndex = Integer.parseInt(input);
            if (newIndex >= 0 && newIndex < numbers.size()) {

                oldValue = numbers.get(newIndex); // once index shot, it is considered "old" for next shots !!!
                numbers.set(newIndex, -1);
                count++;
                for (int i = 0; i <= numbers.size() - 1; i++) {
                    if (numbers.get(i) == -1) {
                        continue;
                    }
                    if (numbers.get(i) <= oldValue) {                 // Increase all the other targets, which have less than or equal value
                        numbers.set(i, numbers.get(i) + oldValue);    // to the shot target, with its value.
                    } else {                                          // Reduce all the other targets, which have greater values
                        numbers.set(i, numbers.get(i) - oldValue);    // than your current target, with its value.
                    }
                }
            } else {
                input = scanner.nextLine();
                continue;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", count);
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", "")
                .replaceAll(", ", " "));



    }
}