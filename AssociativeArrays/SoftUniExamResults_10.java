
package DEMO.AssociativeArraysExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> statPoints = new TreeMap<>();
        Map<String, Integer> statLanguage = new TreeMap<>();

        while (!input.equals("exam finished")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            if (tokens[1].equals("banned")) {  // if (tokens.length ==2)
                statPoints.remove(name);  //remove the user from the contest, but preserve his submissions in the total count
            } else {                      // remove from statPoints !!
                String language = tokens[1];     // You should store each username and his submissions and points.
                Integer points = Integer.parseInt(tokens[2]);
                if (!statLanguage.containsKey(language)) {
                    statLanguage.put(language, 1);
                } else {
                    statLanguage.put(language, statLanguage.get(language) + 1);
                }
                if (!statPoints.containsKey(name)) {   // statPoints.putIfAbsent(name, 0);
                    statPoints.put(name, points);
                } else if (statPoints.get(name) < points) {  // without this check -> 80/100; it is not said explicitely,
                    statPoints.put(name, points);            // but that's how Judge works !!!
                    //statPoints.put(name, statPoints.get(name)+points);  -> if we want to SUM the points; we do not want here
                }
                /*statPoints.putIfAbsent(name, 0);
                if (statPoints.get(name) < points) {
                    statPoints.put(name, points);
                }*/
            }
            input = scanner.nextLine();
        }
        // print each of the participants, ordered descending by their max points, then by username, in the following format:
        System.out.println("Results:");
        statPoints.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(entry -> {
                    System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
                });
        System.out.println("Submissions:");
        statLanguage.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(entry -> {
                    System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
                });


    }
}
