
package DEMO.ListExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        List<Integer> second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        int sum = 0;

        while (!(first.isEmpty() || second.isEmpty())) {  // false || false = true
            if (first.get(0).equals(second.get(0))) {  //same values - no one wins, and the two cards must be removed from the decks
                first.remove(0);
                second.remove(0);
            } else if (first.get(0) > second.get(0)) {    //The player, who has bigger card, takes both cards
                first.add(first.get(0));             //and puts them at the back of his hand
                first.add(second.get(0));            // !!! the second player's card is last
                first.remove(0);
                second.remove(0);
            } else if (first.get(0) < second.get(0)) {
                second.add(second.get(0));    //!!!  card (the winning one) is before it (second to last), otherwise Endless loop!
                second.add(first.get(0));
                first.remove(0);
                second.remove(0);
            }
        }        //когато картите не са равни: на победителя картата се добавя първа, а след това на губещия !!!
        if (first.isEmpty()) {
            for (Integer num : second) {
                sum += num;
            }
            System.out.printf("Second player wins! Sum: %d%n", sum);
        } else {  // Debug 1st ex.: size of 1st array=8 in the end, 2nd array =0; and we calculate the sum!
            /*for (Integer num2 : first) {
                sum += num2;
            }*/
            System.out.printf("First player wins! Sum: %d%n", first.stream().mapToInt(v -> v).sum());
        }


    }
}
