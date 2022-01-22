package DEMO.DataTypeAndVar_MoreEx;

import java.util.Scanner;

public class BalancedBrackets_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int openBracketCount = 0;
        int closeBracketCount = 0;
        boolean isBalanced = true;

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            if (input.equals("(")) {
                openBracketCount++;
                if (openBracketCount - closeBracketCount == 2) { // !!! if ==2, there are 2 opening brackets !
                    isBalanced = false;
                    break;
                }
            } else if (input.equals(")")) {
                closeBracketCount++;
                if (closeBracketCount > openBracketCount) {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (openBracketCount != closeBracketCount) {
            isBalanced = false;
        }
        if (!isBalanced) {
            System.out.println("UNBALANCED");
        } else {
            System.out.println("BALANCED");
        }


    }
}
