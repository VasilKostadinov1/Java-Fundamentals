package DEMO.MethodsLab;

import java.util.Scanner;

public class Orders_05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        calcSum(product, quantity);
    }

    private static void calcSum(String product, int quantity) {
        if (product.equals("coffee")) {
            double result = quantity * 1.50;
            System.out.printf("%.2f",result);
        }else if (product.equals("water")) {
            double result = quantity * 1.00;
            System.out.printf("%.2f",result);
        }else if (product.equals("coke")) {
            double result = quantity * 1.40;
            System.out.printf("%.2f",result);
        }else if (product.equals("snacks")) {
            double result = quantity * 2.00;
            System.out.printf("%.2f",result);
        }
    }

}
