package DEMO.ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());


        int halfSum = numbers.size() / 2;   // declare it outside, otherwise in the For-will be re-sizeable
        for (int i = 0; i < halfSum; i++) {   // only < !!!
            int sum = numbers.get(i) + numbers.get(numbers.size() - 1);
            numbers.set(i,sum);
            numbers.remove(numbers.size() - 1);

        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }
}
