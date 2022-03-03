package DEMO.AssociativeArraysLab;

import java.util.*;
import java.util.stream.Collectors;

public class OddOccurences_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().toLowerCase().split("\\s+");
        Map<String, Integer> counts = new LinkedHashMap<>(); //Use a LinkedHashMap (String  int) to count the occurrences of each word:

        for (String word : words) {  //Pass through all elements in the array and count each word:
            if (counts.containsKey(word)) {
                counts.put(word, counts.get(word) + 1);
            } else {
                counts.put(word, 1);
            }
        }
        //!!! Create a new ArrayList (String), which will hold all the words with odd occurences:
        ArrayList<String> odds = new ArrayList<>();
        for (var entry : counts.entrySet()) {  //!!! var
            if (entry.getValue() % 2 != 0) {
                odds.add(entry.getKey());
            }
        }
        //List<String> odds = counts.entrySet().stream().filter(entry -> entry.getValue() % 2 == 1)
        //      .map(Map.Entry::getKey).collect(Collectors.toList());

        // Print
        System.out.println(String.join(", ", odds));
    }
}
