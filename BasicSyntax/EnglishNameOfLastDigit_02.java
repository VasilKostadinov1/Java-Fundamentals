package DEMO.BasicSyntaxMoreExercise;

import java.util.Scanner;

public class EnglishNameOfLastDigit_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        String[] name = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        String newName = name[num % 10];
        System.out.println(newName);
    }
}
