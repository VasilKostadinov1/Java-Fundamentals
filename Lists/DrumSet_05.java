package DEMO.ListExercisesMore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> DrumSet = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        List<Integer> saveDrumSet = new ArrayList<>(DrumSet);  // List-copy of the initial list, where to store initial data

        String input = scanner.nextLine();
        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);
            for (int i = 0; i < DrumSet.size(); i++) {
                DrumSet.set(i, DrumSet.get(i) - hitPower);
                if (DrumSet.get(i) <= 0) {                          //When a certain drum reaches 0 quality, it breaks
                    if (savings - saveDrumSet.get(i) * 3 > 0) {     //price is calculated by the formula: {initialQuality} * 3
                        DrumSet.set(i, saveDrumSet.get(i));
                        savings -= saveDrumSet.get(i) * 3;

                    } else {                //If she doesn't have enough money for a replacement, the broken drum is removed from the drum set.
                        DrumSet.remove(i);
                        saveDrumSet.remove(i);
                        i--;    // after removing index in a Loop, we should start iterating in the loop from the beginning
                    }           // even InteliJ will tell us - "suspicious List.remove in a Loop"
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(DrumSet.toString().replaceAll("[\\[\\],]", "")
                .replaceAll(", ", " "));
        //System.out.println(DrumSet.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.",savings);

    }
}
