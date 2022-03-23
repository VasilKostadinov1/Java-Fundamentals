
package DEMO.EXAMS.Exams4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\!+")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Go Shopping!")) {
            String[] command = input.split("\\s+");
            String commandName = command[0];
            String item = command[1];

            switch (commandName) {
                case "Urgent":        //add the item at the start of the list
                    if (!numbers.contains(item)) {
                        //numbers.remove(item);
                        numbers.add(0, item);  // !!! not: .add(numbers.indexOf(0),item)
                    }
                    break;
                case "Unnecessary":
                    numbers.remove(item);
                    break;
                case "Correct":     //change its name with the new one
                    String newItem = command[2];
                    if (numbers.contains(item)) {
                        numbers.set(numbers.indexOf(item), newItem);
                    }
                    break;
                case "Rearrange":  //remove it from its current position and add it at the end
                    if (numbers.contains(item)) {
                        numbers.remove(item);
                        numbers.add(item);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
