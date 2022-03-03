package DEMO.AssociativeArraysExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       // 100/100

        Map<String, Integer> materials = new TreeMap<>();
        materials.put("shards", 0);     //	Shadowmourne
        materials.put("fragments", 0);  //	Valanyr
        materials.put("motes", 0);

        Map<String, Integer> junk = new TreeMap<>();
        boolean isValid = false;

        while (!isValid) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int i = 0; i < input.length; i += 2) {
                int value = Integer.parseInt(input[i]);
                String key = input[i + 1].toLowerCase();

                if (key.equals("shards") || key.equals("fragments") || key.equals("motes")) {
                    materials.put(key, materials.get(key) + value);

                    if (materials.get(key) >= 250) {   //Keep track of the key materials - the first that reaches the 250 mark wins the race
                        materials.put(key, materials.get(key) - 250);  // fragments=255; print 255-250 =5

                        if (key.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (key.equals("fragments")) {
                            System.out.println("Valanyr obtained!");
                        } else {
                            System.out.println("Dragonwrath obtained!");
                        }
                        isValid = true;
                        break;
                    }
                } else {
                    junk.put(key, !junk.containsKey(key) ? value : junk.get(key) + value);
                }
            }
        }
        materials.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))  // key materials in descending
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        junk.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));  //junk items in alphabetical order


    }
}
