package DEMO.ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasic_05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Add":
                    int numberToAdd = Integer.parseInt(tokens[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Remove":    // !!! (Integer) as we need to remove the number, not the index!!!
                    //int numberToRemove = (Integer)Integer.parseInt(tokens[1]);
                    //numbers.remove((Integer)Integer.parseInt(tokens[1]));
                    numbers.remove(Integer.valueOf(Integer.parseInt(tokens[1])));
                    break;
                case "RemoveAt":
                    int indexToRemoveAt=Integer.parseInt(tokens[1]);
                    numbers.remove(indexToRemoveAt);

                    break;
                case "Insert":
                    int numberToInsert =Integer.parseInt(tokens[1]);
                    int indexToInsert =Integer.parseInt(tokens[2]);
                    numbers.add(indexToInsert,numberToInsert);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));


    }

}
