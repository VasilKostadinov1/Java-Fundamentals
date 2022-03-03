package DEMO.AssociativeArraysMoreEx;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Snowwhite_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> dwarfsInfo = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!"Once upon a time".equals(input )) {
            String[] command = input.split(" <:> ");
            String nameAndColor = String.format("(%s) %s <->", command[1], command[0]); //(Yellow) Smith <-> 4500
            int physics = Integer.parseInt(command[2]);
            dwarfsInfo.putIfAbsent(nameAndColor, 0);
            int currentPhysics = dwarfsInfo.get(nameAndColor);
            if (currentPhysics < physics) {          // If 2 dwarfs have the same name and the same hat color,
                dwarfsInfo.put(nameAndColor, physics);     // store the one with the higher physics.
            }
            input = scanner.nextLine();
        }                                                    // If 2 dwarfs have the same name but different hat color,
        Map<String, Integer> countColors = new HashMap<>(); // they should be considered different dwarfs, and you should store both of them.
        dwarfsInfo.forEach((key, value) -> {          // key ==(Yellow) Smith <->
            String[] color = key.split(" ");    // color = (Yellow)
            countColors.put(color[0], !countColors.containsKey(color[0]) ? 1 : countColors.get(color[0]) + 1);
        });
        dwarfsInfo.entrySet().stream().
                sorted((a, b) -> {
                    int sort = b.getValue().compareTo(a.getValue());
                    if (sort == 0) {
                        String[] colorOfA = a.getKey().split(" ");
                        String[] colorOfB = b.getKey().split(" ");
                        sort = countColors.get(colorOfB[0]).compareTo(countColors.get(colorOfA[0]));
                    }
                    return sort;
                })
                .forEach(e -> System.out.printf("%s %d%n", e.getKey(), e.getValue()));
    }
}
