package DEMO.BasicSyntaxExercise;

import java.util.Scanner;

public class PadawanEquipment2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double saber = Double.parseDouble(scanner.nextLine());
        double robes = Double.parseDouble(scanner.nextLine());
        double belts = Double.parseDouble(scanner.nextLine());

        double saberCount = Math.ceil(students * 1.10);  // buy 10% more, rounded up to the next integer.
        int beltsCount = students - students / 6;        // every sixth belt is free.

        double totalPrice = saberCount * saber + robes * students + belts * beltsCount;
        if (money >= totalPrice) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalPrice - money);
        }
    }
}
