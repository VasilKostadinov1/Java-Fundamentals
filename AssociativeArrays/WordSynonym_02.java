
package DEMO.AssociativeArraysLab;

import java.util.*;

public class WordSynonym_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        //LinkedHashMap<String, ArrayList<String>> words = new LinkedHashMap<>();
        Map<String, List<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);
        }
        words.forEach((key, value) -> System.out.println(key + " - " + String.join(", ", value)));

        /*for (Map.Entry<String, List<String>> entry : words.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }*/
    }
}
