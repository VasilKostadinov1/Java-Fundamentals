
package DEMO.EXAMS.Exams5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Inventory2_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // by Manekena

        //List<String> itemsList = Arrays.stream((scanner.nextLine().split(", "))).collect(Collectors.toList());
        List<String> itemsList = Arrays.stream((scanner.nextLine().split(",+"))).collect(Collectors.toList());
        IntStream.range(0, itemsList.size()).forEach(i -> itemsList.set(i, itemsList.get(i).trim()));
        String input;

        while (!"Craft!".equals(input = scanner.nextLine())) {
            String[] command = input.split(" - ");
            String item = command[1];
            switch (command[0]) {
                case "Collect":
                    if (!itemsList.contains(item)) {
                        itemsList.add(item);
                    }
                    break;
                case "Drop":
                    itemsList.remove(item);
                    break;
                case "Combine Items":
                    String[] oldNewItem = command[1].split(":");
                    String oldItem=oldNewItem[0];
                    String newItem=oldNewItem[1];
                    if (itemsList.contains(oldItem)) {
                        itemsList.add(((itemsList.indexOf(oldItem)) + 1), newItem);
                    }
                    break;
                case "Renew":
                    if (itemsList.contains(command[1])) {
                        itemsList.add(itemsList.get(itemsList.indexOf(command[1])));
                        itemsList.remove(command[1]);
                    }
                    break;
            }
        }
        //System.out.println(String.join(", ", itemsList));
        System.out.println(itemsList.toString().replaceAll("[\\[\\]]", ""));


    }
}
