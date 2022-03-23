
package DEMO.EXAMS.Exams1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // 83/100

        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();
        int count = 0;

        while (!input.equals("end")) {
            count++;
            String[] tokens = input.split(" ");
            int index1 = Integer.parseInt(tokens[0]);
            int index2 = Integer.parseInt(tokens[1]);
            if (index1 == index2 || index1 < 0 || index1 > numbers.size() || index2 < 0 || index2 > numbers.size()) {
                System.out.println("Invalid input! Adding additional elements to the board");
                numbers.add(numbers.size() / 2, "-" + count + "a"); //should add two matching elements at the middle
                numbers.add(numbers.size() / 2, "-" + count + "a"); // "-{number of moves until now}a"
            } else {
                if (numbers.get(index1).equals(numbers.get(index2))) {  //Every time the player hit two matching elements, you should remove them
                    System.out.printf("Congrats! You have found matching elements - %s!%n", numbers.get(index1));
                    numbers.remove(Math.max(index1,index2));   // !!!Remove 1st the end element, as the size of the input will change!!!
                    numbers.remove(Math.min(index1,index2));   // and after remove the first el., as the shrinked size, will not affect hie removing
                } else {                 //hit two different elements, you should print
                    System.out.println("Try again!");
                }
                if (numbers.isEmpty()) {    //receives "end" before he hits all matching elements
                    System.out.printf("You have won in %d turns!", count);
                    return;  // !!!!
                }
            }
            input = scanner.nextLine();
        }                        //receives "end" before he hits all matching elements
        System.out.println("Sorry you lose :(");
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));



    }

}
