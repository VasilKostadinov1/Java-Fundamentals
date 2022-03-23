
package DEMO.EXAMS.Exams2;

import java.util.Scanner;

public class SoftUniReception_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employee1 = Integer.parseInt(scanner.nextLine());
        int employee2 = Integer.parseInt(scanner.nextLine());
        int employee3 = Integer.parseInt(scanner.nextLine());
        int studentCount = Integer.parseInt(scanner.nextLine());
        int countHour = 0;

        int totalPerHour = employee1 + employee2 + employee3;

        while (studentCount > 0) {
            studentCount -= totalPerHour;
            countHour++;
            if (countHour % 4 == 0) {
                countHour++;
            }
        }
        System.out.printf("Time needed: %dh.", countHour);



    }
}
