package DEMO.AssociativeArraysExercises;

import java.util.*;

public class ForceBook3_09_updated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // 80/100

        String input = scanner.nextLine();
        Map<String, List<String>> sideUsers = new LinkedHashMap<>();    // key = side, user = value ; 1 key -> many users !!!
        // so use in both cases "| and ->" side as a key!!!
        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {                           //{forceSide} | {forceUser}
                String[] tokens = input.split(" \\|+ ");   // split("\\s\\|\\s+")
                String side = tokens[0];
                String user = tokens[1];
                if (!sideUsers.containsKey(side) ) {   // If there is no such force user and no such force side
                    sideUsers.put(side, new ArrayList<>());  //-> create a new force side
                    sideUsers.get(side).add(user);           //and add the force user to the corresponding side.
                } else if (!sideUsers.get(side).contains(user)) {  // •	Only if there is no such force user in any force side
                    sideUsers.get(side).add(user);                 //-> add the force
                } else {
                    continue;
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

                if (!sideUsers.containsKey(side) && !sideUsers.containsKey(user)) {          // same as in case "|"
                    sideUsers.put(side, new ArrayList<>());  // •	If there is no such force user and no such force side -> create new force side and add the force user
                    sideUsers.get(side).add(user);
                    System.out.printf("%s joins the %s side!%n", user, side);
                } else {
                    sideUsers.get(side).add(user);
                    System.out.printf("%s joins the %s side!%n", user, side);
                }
            }
            input = scanner.nextLine();
        }
        // print all the force users.
        sideUsers.entrySet().stream().filter(users -> users.getValue().size() > 0)  //In case there are NO forceUsers, don't print this side
                .forEach(s -> {
                    System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());
                    s.getValue().forEach(person -> System.out.printf("! %s%n", person));
                }); // s.getValue = all force users = List <String>
    }
}

