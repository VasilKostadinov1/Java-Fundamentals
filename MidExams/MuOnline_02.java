
package DEMO.EXAMS.Exams5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MuOnline_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialHealth = 100;
        int initialBitcoin = 0;

        boolean isDead = false;
        int count = 0;
        List<String> rooms = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        while (count <= rooms.size() - 1) {
            String[] tokens = rooms.get(count).split("\\s+");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);
            switch (command) {
                case "potion":
                    if ((initialHealth + number) > 100) { // !!! first made the If check, then increase health
                        number = 100 - initialHealth;   // !!! number/current to be on the left of the equation
                    }
                    initialHealth += number;
                    System.out.printf("You healed for %d hp.%n", number);
                    System.out.printf("Current health: %d hp.%n", initialHealth);
                    break;
                case "chest":
                    initialBitcoin += number;
                    System.out.printf("You found %d bitcoins.%n", number);
                    break;
                default:
                    initialHealth -= number;
                    if (initialHealth > 0) {
                        System.out.printf("You slayed %s.%n", command);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d%n", count + 1);
                        isDead = true;
                        return;  //!!! RETURN - return all program, if break used, we'll continue reading last command "chest 1000"
                    }            // 0/ 100 without return
                    break;
            }
            count++;  // increase count !!!
        }
        if (!isDead) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", initialBitcoin);
            System.out.printf("Health: %d%n", initialHealth);
        }



    }
}
