package DEMO.MethodsLab;

import java.util.Scanner;

public class CalculateRectangleArea_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        int area = getArea(width, height);
        System.out.println(area);
    }

    private static int getArea(int width, int height) {
        return width * height;
    }
}
