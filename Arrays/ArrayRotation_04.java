
package DEMO.ArraysExercises;

import java.util.Scanner;

public class ArrayRotation_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String numbers = scanner.nextLine();         //51 47 32 61 21
        String[] array = scanner.nextLine().split(" ");   // "51" , "47 "
        int countRotation = Integer.parseInt(scanner.nextLine());  // 2

        for (int i = 1; i <= countRotation; i++) {
            String firstElement = array[0];                // take 1st el.
            for (int j = 0; j < array.length - 1; j++) {    // move all elements with 1 to the left
                array[j] = array[j + 1];
            }
            array[array.length - 1] = firstElement;     // last index= 1st element
        }
        System.out.println(String.join(" ", array));


    }
}
