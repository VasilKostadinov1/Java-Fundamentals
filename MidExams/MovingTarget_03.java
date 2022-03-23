
package DEMO.EXAMS.Exams3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();     // 100/100
        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            String commandName = command[0];
            int index = Integer.parseInt(command[1]);
            switch (commandName) {
                case "Shoot":     // Shoot the target at the index if it exists by reducing its value by the given power (integer value).
                    int power = Integer.parseInt(command[2]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.set(index, numbers.get(index) - power);
                        if (numbers.get(index) <= 0) {    // !!! this If should be nested in the other If, or gives 50/100 with 4 Runtime errors
                            numbers.remove(index);        // Remove the target if it is shot
                        }
                    }
                    break;
                case "Add":      //	Insert a target with the received value at the received index if it exists.
                    int value = Integer.parseInt(command[2]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":   //Remove the target at the given index and the ones before and after it depending on the radius
                    int radius = Integer.parseInt(command[2]);
                    if (index - radius >= 0 && index + radius < numbers.size()) {   // If any of the indices in the range is invalid
                        //numbers.remove(index);
                        numbers.subList(index - radius, index + radius + 1).clear();  // +1 because end is exclusive
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", "")  // replace brackets;
                .replaceAll(", ", "|"));          // (separately) replaces commas with "|"


    }
}
