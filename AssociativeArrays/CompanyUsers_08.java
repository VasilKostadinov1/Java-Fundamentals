package DEMO.AssociativeArraysExercises;

import java.util.*;

public class CompanyUsers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();                 // 1 company -> many employers
        Map<String, List<String>> users = new TreeMap<>(); // order the companies by the name in ascending order
        // therefore do NOT use LinkedHashMap !!
        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            String company = tokens[0];
            String userID = tokens[1];
            if (!users.containsKey(company)) {
                users.put(company,new ArrayList<>());
                users.get(company).add(userID);
            } // a company cannot have two employees with the same id. !!!
            else if (!users.get(company).contains(userID)){ // needed this else if check for 100/100. with only else -gives 75/100 !
                users.get(company).add(userID);
            }
            input = scanner.nextLine();
        }
        //order the companies by the name in ascending order. -> used TreeMap
        users.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(id -> System.out.printf("-- %s%n", id));

        });



    }
}
