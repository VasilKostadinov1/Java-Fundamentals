package DEMO.AssociativeArraysExercises;

import java.util.*;

public class ForceBook_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 80/100
        String input = scanner.nextLine();
        Map<String, List<String>> sideUsers = new TreeMap<>();    // key = side, user = value ; 1 key -> many users !!!
        // so use in both cases "| and ->" side as a key!!!
        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {                           //{forceSide} | {forceUser}
                String[] tokens = input.split(" \\|+ ");   // split("\\s\\|\\s+")
                String side = tokens[0];
                String user = tokens[1];
                if (!sideUsers.containsKey(side)) {
                    sideUsers.put(side, new ArrayList<>());
                    sideUsers.get(side).add(user);
                } else {
                    sideUsers.get(side).add(user);
                }
            } else {                                           //{forceUser} -> {forceSide}
                String[] tokens = input.split(" -> ");
                String user = tokens[0];
                String side = tokens[1];
                for (var entry : sideUsers.entrySet()) {     //"if there is such forceUser already and if so, change his/her side."
                    if (entry.getValue().contains(user)) {   // getValue = List<String> = many users
                        sideUsers.get(entry.getKey()).remove(user);
                        //sideUsers.remove(user);
                    }
                }  //"If there is no such forceUser, add him/her to the corresponding forceSide, treating the command as new registered forceUser."

                /*sideUsers.putIfAbsent(side, new ArrayList<>());
                sideUsers.get(side).add(user);
                System.out.printf("%s joins the %s side!%n", user, side); */

                if (!sideUsers.containsKey(side)) {          // same aas in case "|"
                    sideUsers.put(side, new ArrayList<>());
                    sideUsers.get(side).add(user);
                    System.out.printf("%s joins the %s side!%n", user, side);
                } else {
                    sideUsers.get(side).add(user);
                    System.out.printf("%s joins the %s side!%n", user, side);
                }
            }
            input = scanner.nextLine();
        }
        // ordered descending by forceUsers count, then by name, you must print all the forceUsers, ordered by name alphabetically
        sideUsers.entrySet().stream().filter(users -> users.getValue().size() > 0)  //In case there are NO forceUsers, don't print this side
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(s -> {
                    System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());
                    s.getValue().stream().sorted(String::compareTo).forEach(person -> System.out.printf("! %s%n", person));
                }); // s.getValue = all force users = List <String>
    }
}
