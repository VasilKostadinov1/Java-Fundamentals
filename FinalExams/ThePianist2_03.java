
package DEMO.EXAMS_Final.Exam1;

import java.util.*;

public class ThePianist2_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> pianist = new TreeMap<>();  // composer - index 0; key - index 1 !!!in the List

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];
            if (!pianist.containsKey(piece)) {
                pianist.put(piece, new ArrayList<>());
                pianist.get(piece).add(composer);
                pianist.get(piece).add(key);
            } else {
                pianist.put(piece, new ArrayList<>());
            }
        }
        String input2 = scanner.nextLine();
        while (!input2.equals("Stop")) {
            String[] tokens2 = input2.split("\\|");
            String piece = tokens2[1];
            switch (tokens2[0]) {
                case "Add":
                    String composer = tokens2[2];
                    String key = tokens2[3];
                    if (!pianist.containsKey(piece)) {
                        pianist.put(piece, new ArrayList<>());
                        pianist.get(piece).add(composer);
                        pianist.get(piece).add(key);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    } else {
                        System.out.printf("%s is already in the collection!%n", piece);
                    }
                    break;
                case "Remove":
                    if (!pianist.containsKey(piece)) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    } else {
                        pianist.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    }
                    break;
                case "ChangeKey":  // change its key with the given one
                    String newKey = tokens2[2];
                    if (!pianist.containsKey(piece)) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    } else {
                        pianist.get(piece).set(1, newKey);  // 0 or 1 ? If 0 gives incorrect answer in the pre-last print
                        System.out.printf("Changed the key of %s to %s!%n",piece,newKey);
                    }

                    break;
            }
            input2 = scanner.nextLine();    // composer= 0 index; key = 1;
        }
        pianist.entrySet().forEach(kvp-> System.out.printf("%s -> Composer: %s, Key: %s%n",
                kvp.getKey(),kvp.getValue().get(0),kvp.getValue().get(1)));
    }

}
