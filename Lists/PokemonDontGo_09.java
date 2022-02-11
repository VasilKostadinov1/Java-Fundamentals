
package DEMO.ListExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // by MartinBG

        List<Integer> inputNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;
        while (!inputNumbers.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int valueRemoved = 0; // ! we'll store here info for Removed el., as it's needed for print
            //If the given index is LESS than 0, remove the first element of the sequence, and COPY the last element to its place.
            if (index < 0) {
                valueRemoved = inputNumbers.get(0);
                inputNumbers.set(0, inputNumbers.get(inputNumbers.size() - 1));
            } else if (index >= inputNumbers.size()) {                //If the given index is GREATER than the last index of the sequence,
                valueRemoved = inputNumbers.get(inputNumbers.size() - 1);  //remove the last element from the sequence, and COPY the first element to its place.
                inputNumbers.set(inputNumbers.size() - 1, inputNumbers.get(0));
            } else {                    //When you receive an index, you must remove the element at that index from the sequence
                valueRemoved = inputNumbers.remove(index);
            }
            sum += valueRemoved;

            for (int i = 0; i < inputNumbers.size(); i++) {
                if (inputNumbers.get(i) <= valueRemoved) {   //•	You must INCREASE the value of all elements in the sequence which are LESS or EQUAL to
                    inputNumbers.set(i, inputNumbers.get(i) + valueRemoved);    //the removed element, with the value of the removed element
                } else {                  //•	You must DECREASE the value of all elements in the sequence which are GREATER than
                    inputNumbers.set(i, inputNumbers.get(i) - valueRemoved);
                }
            }
        }
        System.out.println(sum);  // print the sum of all REMOVED elements.





    }
}
