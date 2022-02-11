package DEMO.ListExercises;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SoftUniCoursePlanning_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("course start")) {
            String[] tokens = input.split(":");
            String command = tokens[0];
            String lessonTitle = tokens[1];
            switch (command) {
                case "Add":
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(index, lessonTitle);
                    }
                    break;
                case "Remove":
                    if (schedule.contains(lessonTitle)) {
                        schedule.remove(lessonTitle);
                    }
                    break;
                case "Swap": // !!!not implemented -Each time you Swap or Remove a lesson, you should do the same with the Exercises, if there are any, which follow the lessons.
                    String lessonTitle2= tokens[2];
                    int indexTitle1=schedule.indexOf(lessonTitle);
                    int indexTitle2=schedule.indexOf(lessonTitle2);
                    Collections.swap(schedule,indexTitle1,indexTitle2);  // !!!!!!


                    break;
                case "Exercise":
                    String exercise = lessonTitle +"-Exercise";
                    //If the lesson doesn't exist, add the lesson in the end of the course schedule, followed by the Exercise.
                    if (!schedule.contains(lessonTitle)){
                        schedule.add(lessonTitle);
                        schedule.add(exercise);
                    }
                    //add Exercise in the schedule right after the lesson index, if the lesson exists and there is no exercise already,
                    // in the following format "{lessonTitle}-Exercise".
                    else {
                        int indexLesson =schedule.indexOf(lessonTitle); // shows the index of the lesson
                        int indexExercise= indexLesson+1;
                        if (indexLesson==schedule.size()-1){      // if it is last-> for sure there is no exercise
                            schedule.add(indexExercise,exercise);
                        }else if (!schedule.get(indexExercise).equals(exercise)){
                            schedule.add(indexExercise,exercise);
                        }
                    }
                    break;
            }


            input = scanner.nextLine();
        }
        /*int count = 1;
        for (String s : schedule) {
            System.out.println(count+"."+s);
            count++;
        }*/

        IntStream.range(0, schedule.size()).forEach(i -> System.out.printf("%d.%s%n", i + 1, schedule.get(i)));

    }
}
