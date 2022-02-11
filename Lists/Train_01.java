package DEMO.ListExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            // " Add 10"  or "30"
            String[] commandData = command.split(" ");
            if (commandData[0].equals("Add")) {
                int people = Integer.parseInt(commandData[1]);  // [1]
                numbers.add(people);
            } else {
                int peopleToAdd = Integer.parseInt(commandData[0]); // [0]
                for (int i = 0; i < numbers.size(); i++) {
                    int currentWagon = numbers.get(i);           // !!! currentWagon
                    if (currentWagon + peopleToAdd <= maxCapacity) {
                        numbers.set(i, currentWagon + peopleToAdd);
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
         //for (Integer number : numbers) {
         //   System.out.print(number + " ");
        //}
        numbers.forEach(number -> System.out.print(number + " "));


    }

}
