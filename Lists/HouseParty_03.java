package DEMO.ListExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();    // declare inside the for !!!
            String[] tokens = input.split("\\s+");
            String inputName = tokens[0];
            if (tokens[2].equals("going!")) {  // = if(inputData.length==3)
                if (names.contains(inputName)) {
                    System.out.printf("%s is already in the list!%n", inputName);
                } else {
                    names.add(inputName);
                }
            } else if (tokens[2].equals("not")) {
                if (names.contains(inputName)){
                    names.remove(inputName);
                }else {
                    System.out.printf("%s is not in the list!%n",inputName);
                }
            }
        }
        //for (String name : names) {
        //   System.out.println(name);
        //}
        names.forEach(System.out::println);


    }
}
