
package DEMO.EXAMS.Exams5;

import java.util.Scanner;

public class BonusScoringSystem_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // 90/100

        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int addBonus = Integer.parseInt(scanner.nextLine());
        double max = Double.MIN_VALUE;
        double maxStudentAttend = Double.MIN_VALUE;

        for (int i = 1; i <= students; i++) {
            double attendanceStudent = Double.parseDouble(scanner.nextLine());
            double totalBonus =  attendanceStudent / lectures * (5 + addBonus); //formula given
            if (totalBonus > max) {
                max = totalBonus;
                maxStudentAttend = attendanceStudent;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(max));
        System.out.printf("The student has attended %.0f lectures.", maxStudentAttend);

    }
}
