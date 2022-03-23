
package DEMO.EXAMS.Exams2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayModifier_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String commandName = tokens[0];
            switch (commandName) {
                case "swap":
                    int swapIndex1 = Integer.parseInt(tokens[1]);
                    int swapIndex2 = Integer.parseInt(tokens[2]);
                    Collections.swap(numbers, swapIndex1, swapIndex2);
                    break;
                case "multiply":   // save the multiplication of the 2 elements on the 1st index
                    int indMultiply1 = Integer.parseInt(tokens[1]);
                    int indMultiply2 = Integer.parseInt(tokens[2]);
                    numbers.set(indMultiply1, numbers.get(indMultiply1) * numbers.get(indMultiply2));
                    break;
                case "decrease":  // decreases all elements with 1
                    for (int i = 0; i < numbers.size(); i++) {
                        numbers.set(i, numbers.get(i) - 1);
                    }
                    //IntStream.range(0, numbers.size()).forEach(m -> numbers.set(m, numbers.get(m) - 1));
                    //IntStream.range(0, numbers.size()).forEach(e->numbers.set(e, numbers.get(e)-1));
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
