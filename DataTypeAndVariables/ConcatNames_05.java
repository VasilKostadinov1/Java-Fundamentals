package DEMO.DataTypeAndVar_Lab;

import java.util.Scanner;

public class ConcatNames_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String name2 = scanner.nextLine();
        String delimiter = scanner.nextLine();

        //System.out.printf("%s%s%s",name,delimiter,name2);

        StringBuilder sb = new StringBuilder();
        sb.append(name).append(delimiter).append(name2);
        System.out.println(sb);
    }
}
