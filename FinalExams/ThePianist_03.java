
package DEMO.EXAMS_Final.Exam1;

import java.util.*;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        //String input = scanner.nextLine();
        //"{piece}|{composer}|{key}"
        Map<String, List<String>> pianist = new TreeMap<>(); // List: composer - index 0; key - index 1

        // the for and while cycles are separate. They read diff. data !!!
        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split("\\|"); // !!!scanner should be read inside the for!
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];
            pianist.put(piece, new ArrayList<>());
            pianist.get(piece).add(composer);
            pianist.get(piece).add(key);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] tokens2 = command.split("\\|+");
            String commandName = tokens2[0];
            String piece2 = tokens2[1];
            switch (commandName) {
                case "Add":
                    String composer2 = tokens2[2];
                    String key2 = tokens2[3];
                    if (pianist.containsKey(piece2)) {
                        System.out.printf("%s is already in the collection!%n", piece2);
                    } else {
                        pianist.put(piece2, new ArrayList<>());
                        pianist.get(piece2).add(composer2);
                        pianist.get(piece2).add(key2);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece2, composer2, key2);
                    }
                    break;
                case "Remove":
                    if (pianist.containsKey(piece2)) {
                        pianist.remove(piece2);
                        System.out.printf("Successfully removed %s!%n", piece2);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece2);
                    }
                    break;
                case "ChangeKey":
                    String newKey2 = tokens2[2];
                    if (!pianist.containsKey(piece2)) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece2);
                    } else {
                        // change its key with the given one
                        pianist.get(piece2).set(1, newKey2); // !! 1 - see it in the print; key is indexed = 1
                        System.out.printf("Changed the key of %s to %s!%n", piece2, newKey2);
                    }
                    break;
            }
            command = scanner.nextLine();        // composer=0; key =1;
        }
        //sorted by their name and by the name of their composer in alphabetical order -> TreeMap
        pianist.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(kvp -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                        kvp.getKey(), kvp.getValue().get(0), kvp.getValue().get(1)));

    }
}
