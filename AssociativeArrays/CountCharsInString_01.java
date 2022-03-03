
package DEMO.AssociativeArraysExercises;

import java.util.*;
import java.util.stream.Collectors;

public class CountCharsInString_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> mapTest = new LinkedHashMap<>(); // ! use LinkedHash, as we want to print in order of appearance

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol != 32) {
                if (!mapTest.containsKey(symbol)) {
                    mapTest.put(symbol, 1);
                } else {
                    mapTest.put(symbol, mapTest.get(symbol) + 1);
                }
            }
        }
        /*for (Map.Entry<Character, Integer> entry : mapTest.entrySet()) {   // var = Map.Entry<Character, Integer>
            System.out.printf("%s -> %s%n",entry.getKey(),entry.getValue());
        }*/
        mapTest.forEach((key,value)-> System.out.printf("%c -> %d%n",key,value) );


    }
}
