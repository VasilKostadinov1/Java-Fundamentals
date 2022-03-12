
package DEMO.TextProcessingLab;

import java.util.Scanner;

public class Substring_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String text = scanner.nextLine();

        StringBuilder sb = new StringBuilder(text);
        int index = sb.indexOf(key);     // Find the first index where the key appears.

        while (index != -1) {            // indexOf to return -1 when no match is found.
            sb.delete(index, index + key.length());
            index = sb.indexOf(key);
        }
        System.out.println(sb);
        // All the above variations returns -1 if the specified char/substring is not found in the particular String.

    }
}
