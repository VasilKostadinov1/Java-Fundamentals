
package DEMO.EXAMS.Exams1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheLift_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());

        List<Integer> lift = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        for (int i = 0; i < lift.size(); i++) {
            if (people < 1) {
                break;
            }
            while (lift.get(i) < 4) {
                if (people < 1) {
                    break;
                }
                lift.set(i, lift.get(i)+1); // +1 because we start from 0, and want to fill till the size is 4
                people--;
            }
        }
        if (people == 0 && !lift.isEmpty()) {
            System.out.println("The lift has empty spots!");
        } else if (people > 0 ) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
        }
        System.out.println(lift.toString().replaceAll("[\\[\\],]", ""));
    }
}
