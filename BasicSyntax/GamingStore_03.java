package DEMO.BasicSyntaxMoreExercise;

import java.util.Scanner;

public class GamingStore_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();     // from Basic !

        double balance = Double.parseDouble(input);  //On the first line, you will receive your current balance – a floating-point number in the range
        double totalmoney = balance;
        double totalSpend = 0;
        double price;

        while (!"Game time".equalsIgnoreCase(input = scanner.nextLine())) {

            price = 0;
            if (balance == 0) {    //If at any point, the user has $0 left, print “Out of money!” and end the program.
                System.out.println("Out of money!");
                break;
            }
            switch (input) {
                case "OutFall 4":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                default:     //  If a game the user is trying to buy is not present in the table above, print “Not Found” and read the next line

                    System.out.println("Not Found");
                    break;
            }
            if (balance >= price && price > 0) {  // If the game exists and the player has the money for it, print “Bought {nameOfGame}”

                totalSpend += price;
                balance -= price;
                System.out.printf("Bought %s%n", input);

            }else if (balance < price && price > 0) {  //Alternatively, if the user is trying to buy a game which they can’t afford, print “Too Expensive” and read
                //the next line.

                System.out.println("Too Expensive");
            }
        }
        if (balance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpend, (totalmoney - totalSpend));
        }
    }
}
