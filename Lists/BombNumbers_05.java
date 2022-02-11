package DEMO.ListExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        int bombIndex = scanner.nextInt();
        int powerIndex = scanner.nextInt();

        while (numbers.contains(bombIndex)) {
            int targetIndex = numbers.indexOf(bombIndex);
            int endIndex = Math.min(targetIndex + powerIndex,numbers.size()-1); // !! min=targetIndex+powerIndex
            int startIndex = Math.max(0,targetIndex - powerIndex);            // max = targetIndex-powerIndex
            numbers.subList(startIndex,endIndex+1).clear();
        }                // we need declare min & max, otherwise throws exception on 2nd input, as 9 is out of the size
                         // and is not taken as element 9
        System.out.println(numbers.stream().mapToInt(v -> v).sum());
        /*int sum=0;
        for (Integer number : numbers) {
            sum+=number;
        }
        System.out.println(sum); */


    }


}
