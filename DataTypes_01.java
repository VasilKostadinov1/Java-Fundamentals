package DEMO.MethodsMoreExercise;

import java.util.Scanner;

public class DataTypes_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String multiplier = scanner.nextLine();

        multipleMethod(input, multiplier);
    }

    private static void multipleMethod(String input, String multiplier) {
        switch (input) {
            case "int":
                System.out.println(Integer.parseInt(multiplier) * 2);

                break;
            case "real":
                System.out.printf("%.2f", Double.parseDouble(multiplier) * 1.50);

                break;
            case "string":
                System.out.println("$" + multiplier + "$");

                break;

        }
    }
}
