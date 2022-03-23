
package DEMO.EXAMS.Exams5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());  // Iron, Wood, Sword

        String input = scanner.nextLine();      // 100/100 by myself
        while (!input.equals("Craft!")) {
            String[] tokens = input.split(" - ");   // Collect - Gold
            String commandName = tokens[0];
            String item = tokens[1];
            switch (commandName) {
                case "Collect":
                    if (!numbers.contains(item)) {
                        numbers.add(item);
                    }
                    break;
                case "Drop":
                    numbers.remove(item);
                    break;
                case "Combine Items":
                    String[] split = tokens[1].split(":");  // !!!
                    String oldItem = split[0];
                    String newItem = split[1];
                    if (numbers.contains(oldItem)) {  // add the new item after the old one.
                        int index = numbers.indexOf(oldItem);
                        numbers.add(index + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (numbers.contains(item)) {
                        numbers.remove(item);
                        numbers.add(item);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
        //System.out.println(String.join(", ", numbers));

    }
}
