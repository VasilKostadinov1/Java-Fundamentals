package DEMO.AssociativeArraysLab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        TreeMap<Integer, Integer> mapCount = new TreeMap<>();

        Arrays.stream(numbers).forEach(num->{
            if (!mapCount.containsKey(num)) {
                mapCount.put(num, 0);
            }
            mapCount.put(num, mapCount.get(num) + 1);  // ! not else, as we want to count from the very first meeting the word
        });
        /*for (Integer num : numbers) {
            if (!mapCount.containsKey(num)) {
                mapCount.put(num, 0);
            }
            mapCount.put(num, mapCount.get(num) + 1);
        }*/
        for (Map.Entry<Integer, Integer> entry : mapCount.entrySet()) {
            System.out.printf("%s -> %s%n",entry.getKey(),entry.getValue());
        }

    }
}
