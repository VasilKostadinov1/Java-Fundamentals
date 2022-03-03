package DEMO.AssociativeArraysExercises;

import java.util.*;

public class CompanyUsers2_08_updated {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();                 // 1 company -> many employers
        Map<String, List<String>> users = new LinkedHashMap<>();
        // therefore do NOT use LinkedHashMap !!
        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            String company = tokens[0];
            String userID = tokens[1];
            if (!users.containsKey(company)) {
                users.put(company, new ArrayList<>());
                users.get(company).add(userID);
            } // a company cannot have two employees with the same id. !!!
            else if (!users.get(company).contains(userID)) { // needed this else if check for 100/100. with only else -gives 75/100 !
                users.get(company).add(userID);
            }
            input = scanner.nextLine();
        }
        //Print the company name and each employee's id in the following format
        users.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(id -> System.out.printf("-- %s%n", id));

        });
    }
}
