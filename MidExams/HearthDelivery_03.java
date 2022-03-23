
package DEMO.EXAMS.Exams4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HearthDelivery_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("@"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        String input = scanner.nextLine();
        int index = 0; // initial index , first house (index 0) ; current position

        while (!input.equals("Love!")) {
            String[] command = input.split("\\s+");
            //String commandName = command[0];
            int length = Integer.parseInt(command[1]);
            index += length;  // starts at the position of the first house (index 0) and must jump by a given length

            if (index > numbers.size() - 1) {
                index = 0;        //if he does jump outside of it, he should start from the first house again (index 0)
            }
            // not index = 0; but numbers.get(index) - there is movement!!!
            if (numbers.get(index) == 0) {               // Cupid jumps to a house where the needed hearts are already 0
                System.out.printf("Place %d already had Valentine's day.%n", index);
            } else if (numbers.get(index) - 2 <= 0) {    // If the needed hearts for a certain house become equal to 0
                numbers.set(index, 0);
                System.out.printf("Place %d has Valentine's day.%n", index);
            } else {
                numbers.set(index, numbers.get(index) - 2);  //decrease by 2
            }
            input = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", index);

        int successful = (int) IntStream.range(0, numbers.size()).filter(i -> numbers.get(i) != 0).count();
        if (successful == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", successful);
        }
        /*int count =0;
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) !=0) {
                count++;
            }
        }
        if(count==0){
            System.out.println("Mission was successful.");
        }else{
            System.out.printf("Cupid has failed %d places.",count);
        }*/

    }
}
