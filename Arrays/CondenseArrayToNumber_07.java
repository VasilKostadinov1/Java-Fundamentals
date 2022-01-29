package DEMO.ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] num = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(e->Integer.parseInt(e)).toArray();

        int count = num.length - 1;
        while (count > 0) {
            for (int i = 0; i < num.length - 1; i++) {
                int condense = num[i] + num[i + 1];
                num[i] = condense;
            }
            count--;
        }
        System.out.println(num[0]);

    }
}
