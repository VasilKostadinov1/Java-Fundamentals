package DEMO.AssociativeArraysLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CountRealNumbers2_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e->Integer.parseInt(e)).collect(Collectors.toList());

        TreeMap<Integer, Integer> mapCount = new TreeMap<>();

        for (Integer number : numbers) {
            if (!mapCount.containsKey(number)){
                mapCount.put(number, 0);
            }
            mapCount.put(number, mapCount.get(number)+1);
        }
        for (var entry : mapCount.entrySet()) {
            System.out.printf("%d -> %d%n",entry.getKey(),entry.getValue());
        }

    }
}
