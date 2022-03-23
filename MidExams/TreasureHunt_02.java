
package DEMO.EXAMS.Exams6;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> initialLoot = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Yohoho!")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {       // if i=0, also "Loot" will be added to the initial list
                        if (!initialLoot.contains(tokens[i])) {     // which is incorrect -> start from 1 !!!
                            initialLoot.add(0, tokens[i]);    // Insert the items at the beginning
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index > 0 && index < initialLoot.size()) {
                        String toBeRemoved = initialLoot.remove(index);
                        initialLoot.add(toBeRemoved);
                    }
                    break;
                case "Steal":
                    int countSteal = Integer.parseInt(tokens[1]);
                    if (countSteal > initialLoot.size()) {  // If there are fewer items than the given count, remove as much as there are.
                        countSteal = initialLoot.size();
                    }
                    /*List<String> steal = new ArrayList<>();
                    for (int i = initialLoot.size() - countSteal; i < initialLoot.size(); i++) {
                        steal.add(initialLoot.get(i));
                    }*/
                    List<String> steal = initialLoot.subList(initialLoot.size() - countSteal, initialLoot.size());
                    System.out.println(String.join(", ", steal));
                    initialLoot = initialLoot.subList(0, initialLoot.size() - countSteal);
                    break;
            }
            input = scanner.nextLine();
        }
        //System.out.println(initialLoot);
        if (initialLoot.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.%n",
                    initialLoot.stream().mapToDouble(String::length).average().orElse(0.00));
        }



    }
}
