
package DEMO.TextProcessingMoreExercise;

import java.util.Scanner;

public class AsciiSumator_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        String text = scanner.nextLine();
        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) > first && text.charAt(i) < second) {
                sum += text.charAt(i);
            }
        }
        System.out.println(sum);
        //if (text.charAt(i)>Math.min(first,second) && text.charAt(i)<Math.max(first,second))


    }
}
