package DEMO.ListsLab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toList());


        for (int i = 0; i < numbers.size() - 1; i++) {  // not going to last element, as we can't compare it with anything
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                double sum = numbers.get(i) + numbers.get(i + 1);
                numbers.set(i, sum);
                numbers.remove(i + 1);
                i = -1; // !!!we want: when we go back to the For cycle, we'll start from zero index again (not first). Debug to see.
            }           // as we want the zero index to be updates
        }
        //for (Double number : numbers) {
        //   System.out.printf("%.0f ", number);
        //}
        StringBuilder sb = new StringBuilder();
        numbers.forEach(number -> sb.append((new DecimalFormat("0.#")).format(number)).append(" "));
        System.out.println(sb);

    }
}
