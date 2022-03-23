
package DEMO.EXAMS.Exams3;

import java.util.Scanner;

public class CounterStrike_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        int countWin = 0;
        boolean isDead = false;

        String input = scanner.nextLine();
        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);
            // written : initialEnergy<=0, also gives correct outcome, but 71/100
            if (initialEnergy - distance < 0) {
                isDead = true;
                break;
            } else {
                initialEnergy -= distance;
                countWin++;
            }  //Every third won battle increases your energy with the value of your current count of won battles.
            if (countWin % 3 == 0) {
                initialEnergy += countWin;
            }
            input = scanner.nextLine();
        }
        if (isDead) {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", countWin, initialEnergy);
        } else {
            System.out.printf("Won battles: %d. Energy left: %d", countWin, initialEnergy);
        }
    }
}
