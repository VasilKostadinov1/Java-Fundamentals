package DEMO.ListExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commandData = command.split("\\s+");
            String commandName = commandData[0];
            int element = Integer.parseInt(commandData[1]);
            if (commandName.equals("Delete")) {
                numbers.removeAll(Arrays.asList(element));
                //numbers.removeAll(List.of(element));

            } else if (commandName.equals("Insert")) {
                int index = Integer.parseInt(commandData[2]);
                numbers.add(index, element);
            }
            command = scanner.nextLine();
        }
        printList(numbers);
    }

    private static void printList(List<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
