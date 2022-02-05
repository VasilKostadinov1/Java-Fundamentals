package DEMO.MethodsLab;

import java.util.Scanner;

public class Grades_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        printWords(grade);
    }
    public static void printWords(double grade) {
        if (grade>=2.0 && grade<=2.99){
            System.out.println("Fail");
        }else if (grade>=3.0 && grade<=3.49){
            System.out.println("Poor");
        }else if (grade>=3.50 && grade<=4.49){
            System.out.println("Good");
        }else if (grade>=4.50 && grade<=5.49){
            System.out.println("Very good");
        }else {
            System.out.println("Excellent");

        }
    }
}
