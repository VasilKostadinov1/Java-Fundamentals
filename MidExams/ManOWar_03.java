
package DEMO.EXAMS.Exams6;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        List<Integer> warShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        int maxHealth = Integer.parseInt(scanner.nextLine());
        boolean isDead = false;

        String input = scanner.nextLine();
        while (!input.equals("Retire")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Fire":
                    int index = Integer.parseInt(command[1]);
                    int damage = Integer.parseInt(command[2]);
                    if (index > 0 && index < pirateShip.size() && index < warShip.size()) {
                        warShip.set(index, warShip.get(index) - damage);
                        if (warShip.get(index) <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            isDead = true;
                            return;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    int damage2 = Integer.parseInt(command[3]);
                    if ((startIndex >= 0 && startIndex < pirateShip.size()) && (endIndex >= startIndex
                            && endIndex < pirateShip.size())) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateShip.set(i, pirateShip.get(i) - damage2);
                            if (pirateShip.get(i) <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                isDead = true;
                                return;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int indexRepair = Integer.parseInt(command[1]);
                    int health = Integer.parseInt(command[2]);
                    if (indexRepair > 0 && indexRepair < pirateShip.size()) {
                        pirateShip.set(indexRepair, pirateShip.get(indexRepair) + health);
                    }
                    if (health > maxHealth) {
                        health = maxHealth;
                    }
                    //int currentHealth = pirateShip.get(indexRepair);
                    //if (currentHealth + health > maxHealth) {
                    //    health = maxHealth - currentHealth;
                    //}
                    break;
                case "Status":
                    double maxLessThan20 = maxHealth * 0.20;
                    int count = 0;
                    for (int i = 0; i < pirateShip.size(); i++) {
                        if (pirateShip.get(i) < maxLessThan20) {
                            count++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", count);
                    break;
            }
            input = scanner.nextLine();
        }
        int pirateShipPoint = pirateShip.stream().reduce(0, (a, b) -> a + b);
        int warShipPoint = warShip.stream().reduce(0, Integer::sum);
        /*int sum=0;
        for (Integer p : pirateShip) {
            sum+=p;
        }
        System.out.println(sum);*/

        System.out.printf("Pirate ship status: %d%n", pirateShipPoint);
        System.out.printf("Warship status: %d", warShipPoint);

        // 3rd way for sum !!!
        //System.out.printf("Pirate ship status: %d%n", pirateShip.stream().mapToInt(v -> v).sum());
        //System.out.printf("War ship status: %d%n", warShip.stream().mapToInt(v -> v).sum());


    }
}
