
package DEMO.ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");

            switch (command[0]) {
                case "Contains":
                    int numberToContain = Integer.parseInt(command[1]);
                    if (numbers.contains(numberToContain)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String subCommand = command[1];
                    if (subCommand.equals("even")) {
                        numbers.stream().filter(n -> n % 2 == 0).forEach(e -> System.out.print(e + " "));
                        /*for (Integer number : numbers) {
                            if (number % 2 == 0) {
                                System.out.print(number + " ");
                            }
                        }*/
                        System.out.println();
                    } else if (command[1].equals("odd")) {
                        for (Integer number2 : numbers) {
                            if (number2 % 2 != 0) {
                                System.out.print(number2 + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Get":
                    if (command[1].equals("sum")) {
                        int sum = numbers.stream().mapToInt(v -> v).sum();
                        //int max =numbers.stream().mapToInt(s->s).max().orElse(0);
                        System.out.println(sum);
                        /*int sum = 0;
                        for (Integer number : numbers) {
                            sum += number;
                        }
                        System.out.println(sum);*/
                    }
                    break;
                case "Filter":
                    String condition = command[1];
                    int number = Integer.parseInt(command[2]);
                    if (condition.equals(">=")) {
                        numbers.stream().filter(n -> n >= number).forEach(e -> System.out.print(e + " "));
                        /*for (Integer n : numbers) {
                            if (n >= number) {
                                System.out.print(n + " ");
                            }
                        }*/
                        System.out.println();
                    } else if (condition.equals(">")) {
                        numbers.stream().filter(n -> n > number).forEach(e -> System.out.print(e + " "));
                        /*for (Integer n1 : numbers) {
                            if (n1 > number) {
                                System.out.print(n1 + " ");
                            }
                        }*/
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
                    break;
            }
            input = scanner.nextLine();
        }


    }
}
