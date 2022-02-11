
package DEMO.ListExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream((scanner.nextLine().split("\\|"))).collect(Collectors.toList());
        Collections.reverse(numbers);

        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            sb.append(number).append(" ");
        }
        System.out.println(sb.toString().trim().replaceAll("\\s+", " "));


    }
}
