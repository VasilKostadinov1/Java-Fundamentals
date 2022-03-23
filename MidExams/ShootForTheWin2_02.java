
package DEMO.EXAMS.Exams3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin2_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        int count = 0;

        while (!command.equals("End")) {
            int index = Integer.parseInt(command);

            if (index < targets.size()) {         // index is in the List
                int currentEl = targets.get(index);

                if (targets.get(index) == -1) {  // you can't shoot a target, which is already shot
                    command = scanner.nextLine();
                }
                targets.set(index, -1);
                count++;
                for (int i = 0; i < targets.size(); i++) {

                    if (targets.get(i) != -1 && targets.get(i) > currentEl) {
                        targets.set(i, targets.get(i) - currentEl);
                    } else if (targets.get(i) != -1 && targets.get(i) <= currentEl) {
                        targets.set(i, targets.get(i) + currentEl);
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", count);
        for (Integer target : targets) {
            System.out.printf("%d ", target);
        }
    }
}
