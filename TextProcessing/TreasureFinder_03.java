
package DEMO.TextProcessingMoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureFinder_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> key = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("find")) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int i = 0; i < input.length(); i++) {  // input.
                if (count == key.size()) {              // start looping from the beginning of the key
                    count = 0;
                }              // input.charAt(i) - key.get(count) will append 104,105...we need the letter
                // i=105-1=104=h; k=107-2=105=I; .... g=103-3=100=d;……
                // decrease the ascii code of each character with a corresponding number of the key sequence.
                int decreased = (input.charAt(i) - key.get(count));
                sb.append((char)decreased);   // !!! (char)
                count++;
            }
            String typeMetal = sb.substring(sb.indexOf("&") + 1, sb.lastIndexOf("&"));
            String coordinates = sb.substring(sb.indexOf("<") + 1, sb.lastIndexOf(">"));
            input = scanner.nextLine();

            System.out.printf("Found %s at %s%n", typeMetal, coordinates);
        }

    }
}
