package DEMO.ListExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandData = command.split("\\s+");
            String commandName = commandData[0];
            switch (commandName) {
                case "Add":
                    int numberToAdd = Integer.parseInt(commandData[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(commandData[1]);
                    int indexToInsert = Integer.parseInt(commandData[2]);
                    //isValidIndex(indexToInsert,numbers.size());         // Method
                    if (isValidIndex(indexToInsert, numbers.size())) {
                        numbers.add(indexToInsert, numberToInsert);

                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(commandData[1]);
                    if (isValidIndex(indexToRemove, numbers.size())) {
                        numbers.remove(indexToRemove);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String shiftType = commandData[1];
                    int countShift = Integer.parseInt(commandData[2]);
                    if (shiftType.equals("left")) {  //	Shift left {count} - first number becomes last 'count' times
                        // take 1st el., move to the end, delete from 1st position
                        for (int i = 0; i < countShift; i++) {
                            int firstNum = numbers.get(0);  // !!! declare inside the For, or gives incorrect result !!!
                            numbers.add(firstNum);
                            numbers.remove(0);
                        }
                        //take last el., move to the beginning, delete from last position
                    } else if (shiftType.equals("right")) {  // Shift right {count} - last number becomes first 'count' times
                        for (int i = 0; i < countShift; i++) {
                            int lastNum = numbers.get(numbers.size() - 1);
                            numbers.add(0, lastNum);
                            numbers.remove(numbers.size() - 1);
                        }
                    }

                    break;
            }
            command = scanner.nextLine();
        }
        numbers.forEach(number -> System.out.print(number + " "));

    }

    public static boolean isValidIndex(int index, int size) {
        return index >= 0 && index < size;
    }
}
