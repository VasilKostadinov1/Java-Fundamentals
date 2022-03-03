package DEMO.AssociativeArraysMoreEx;

import java.util.*;

public class Snowwhite2_withObjects {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // by MartinBG

        Map<String, Map<String, Dwarf>> dwarfsByColor = new LinkedHashMap<>();

        String input = "";
        while (!"Once upon a time".equals(input = scanner.nextLine())) {

            String[] arr = input.split(" <:> ");

            String name = arr[0];
            String color = arr[1];
            int physics = Integer.parseInt(arr[2]);

            dwarfsByColor.putIfAbsent(color, new LinkedHashMap<>());
            dwarfsByColor.get(color)
                    .merge(name, new Dwarf(name, color, physics),
                            (oldD, newD) -> (oldD.physics >= newD.physics) ? oldD : newD);

        }

        final Comparator<Dwarf> dwarfComparator = (dwarf1, dwarf2) -> {
            int sort = Integer.compare(dwarf2.physics, dwarf1.physics);
            if (sort == 0) {
                sort = Integer.compare(dwarfsByColor.get(dwarf2.hatColor).size(),
                        dwarfsByColor.get(dwarf1.hatColor).size());
            }
            return sort;
        };
        //You must order the dwarfs by physics in descending order and then by the total
        // count of dwarfs with the same hat color in descending order.
        dwarfsByColor.values().stream()
                .map(Map::values)
                .flatMap(Collection::stream)
                .sorted(dwarfComparator)
                .forEach(dwarf -> System.out.printf("(%s) %s <-> %d%n", dwarf.hatColor, dwarf.name, dwarf.physics));
    }

    private static final class Dwarf {
        private final String name;
        private final String hatColor;
        private final int physics;

        public Dwarf(String name, String hatColor, int physics) {
            this.name = name;
            this.hatColor = hatColor;
            this.physics = physics;
        }
    }
}
