package DEMO.DataTypeAndVar_Lab;

import java.util.Scanner;

public class ConvertMeterToKm_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f",n/1000);
    }
}
