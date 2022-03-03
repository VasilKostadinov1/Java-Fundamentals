package DEMO.AssociativeArraysLab;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OddOccurences2_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().toLowerCase().split("\\s+");

        Map<String, Integer> words = IntStream.range(0, input.length).boxed()
                .collect(Collectors.toMap(i -> input[i], i -> 1, Integer::sum, LinkedHashMap::new));
        List<String> output = words.entrySet().stream().filter(entry -> entry.getValue() % 2 == 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println(String.join(", ", output));

    }
}
