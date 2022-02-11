
package DEMO.ListExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> names = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("3:1")) {
            String[] commandData = command.split("\\s+");
            String commandName = commandData[0];
            if (commandName.equals("merge")) {
                int startIndex = Integer.parseInt(commandData[1]);
                int endIndex = Integer.parseInt(commandData[2]);
                if (startIndex < 0) {  // If any of the given indexes is out of the array,
                    startIndex = 0;    // you must take ONLY the range that is INSIDE the array  !!!
                }
                if (endIndex > names.size() - 1) {
                    endIndex = names.size() - 1;
                }
                if (startIndex >= 0 && startIndex <= names.size() - 1 && endIndex >= 0 && endIndex <= names.size() - 1) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = startIndex; i <= endIndex; i++) {
                        sb.append(names.get(i));
                    }
                    names.subList(startIndex, endIndex + 1).clear();  // !!! subList().clear -> ==== ".remove" in the Forloop
                    names.add(startIndex, sb.toString());   // !!! .toString

                }
            } else if (commandName.equals("divide")) {
                int index = Integer.parseInt(commandData[1]);
                int partition = Integer.parseInt(commandData[2]);
                String elementForDivide = names.get(index);
                // {abcdef, ghi, jkl} -> {ghi, jkl}
                names.remove(index);

                int partSize = elementForDivide.length() / partition;
                int begin = 0;

                for (int i = 0; i < partition; i++) {   // till the pre-last element
                    names.add(index, elementForDivide.substring(begin, begin + partSize));
                    index++;
                    begin += partSize;
                }  // for the last element
                names.add(index, elementForDivide.substring(begin));  // last
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(" ", names));


    }
}
