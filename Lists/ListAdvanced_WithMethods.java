package DEMO.ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListAdvanced_WithMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");

            switch (command[0]) {
                case "Contains":
                    checkContains(numbers, command);
                    break;
                case "Print":
                    checkPrint(numbers, command);
                    break;
                case "Get":
                    checkGet(numbers, command);
                    break;
                case "Filter":
                    checkFilter(numbers, command);
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static void checkFilter(List<Integer> numbers, String[] command) {
        String condition = command[1];
        int number = Integer.parseInt(command[2]);
        if (condition.equals(">=")) {
            for (Integer n : numbers) {
                if (n >= number) {
                    System.out.print(n + " ");
                }
            }
            System.out.println();
        } else if (condition.equals(">")) {
            for (Integer n1 : numbers) {
                if (n1 > number) {
                    System.out.print(n1 + " ");
                }
            }
            System.out.println();
        } else if (condition.equals("<=")) {
            for (Integer n : numbers) {
                if (n <= number) {
                    System.out.print(n + " ");
                }
            }
            System.out.println();
        } else if (condition.equals("<")) {
            for (Integer n1 : numbers) {
                if (n1 < number) {
                    System.out.print(n1 + " ");
                }
            }
            System.out.println();
        }

    }

    private static void checkGet(List<Integer> numbers, String[] command) {
        if (command[1].equals("sum")) {
            int sum = 0;
            for (Integer number : numbers) {
                sum += number;
            }
            System.out.println(sum);
        }

    }

    private static void checkPrint(List<Integer> numbers, String[] command) {
        String subCommand = command[1];
        if (subCommand.equals("even")) {
            for (Integer number : numbers) {
                if (number % 2 == 0) {
                    System.out.print(number + " ");
                }
            }
            System.out.println();
        } else if (command[1].equals("odd")) {
            for (Integer number2 : numbers) {
                if (number2 % 2 != 0) {
                    System.out.print(number2 + " ");
                }
            }
            System.out.println();
        }
    }

    private static void checkContains(List<Integer> numbers, String[] input) {
        int numberToContain = Integer.parseInt(input[1]);
        if (numbers.contains(numberToContain)) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }



    }

}
