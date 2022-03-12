package DEMO.TextProcessingLab;

import java.util.Scanner;

public class Test_Text {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("unhappy".substring(2));     // -> happy
        System.out.println("unhappy".substring(2, 4));  // -> ha


        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append("Hello Peter"));
        System.out.println(sb.charAt(1));
        System.out.println(sb.insert(11, " Ivanov"));
        System.out.println(sb.replace(6, 11, "George"));
    }
}
