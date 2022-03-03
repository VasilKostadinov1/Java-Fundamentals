package DEMO.AssociativeArraysLab;

import java.util.*;

public class Example_withList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.asList("hello", "bye", "the", "quick", "brown", "fox", "jumps", "over", "big");

        Map<Integer, List<String>> wordsByLength = new TreeMap<>();
        for (String word : words) {
            int key = word.length();
            List<String> values = wordsByLength.get(key);
            if (values != null) {
                values.add(word);
            } else {
                values = new ArrayList<>();
                values.add(word);
                wordsByLength.put(key, values);
            }
        }
        for (Map.Entry<Integer, List<String>> entry : wordsByLength.entrySet()) {
            System.out.println(entry.getKey()+ " -> " +entry.getValue());
        }


    }
}
