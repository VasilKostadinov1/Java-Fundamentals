package DEMO.ArraysLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DayOfWeek_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        List<String> dayList = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        int currentDay = Integer.parseInt(scanner.nextLine());

        if (currentDay >= 1 && currentDay <= 7) {
            //System.out.println(days[currentDay-1]);
            System.out.println(dayList.get(currentDay-1));
        } else {
            System.out.println("Invalid day!");
        }


    }
}
