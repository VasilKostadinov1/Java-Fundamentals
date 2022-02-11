
package DEMO.ListExercisesMore;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Messaging_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String text = scanner.nextLine();
        List<Character> textList = IntStream.range(0, text.length()).mapToObj(text::charAt).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        for (int num : numbersList) {  //For each element of the list you have to take the sum of its digits
            int index = 0;    // index = sum : 2+9+9+9 = 29
            while (num > 0) {
                index += num % 10;
                num /= 10;
            }
            if (!(index < textList.size() - 1)) {  //. If the index is greater than the length of the text, start counting from the beginning
                index = (index % textList.size());
            }
            sb.append(textList.get(index)); //and take the element corresponding to that index from the text.
            textList.remove(index);  //After getting the element from the text, you have to remove the character
        }
        System.out.println(sb);



    }
}
