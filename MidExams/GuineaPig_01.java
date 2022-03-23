
package DEMO.EXAMS.Exams4;

import java.util.Scanner;

public class GuineaPig_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    // 90/100

        double food = Double.parseDouble(scanner.nextLine());  //in kilograms
        double hay = Double.parseDouble(scanner.nextLine());
        double cover = Double.parseDouble(scanner.nextLine());
        double weight = Double.parseDouble(scanner.nextLine());

        double foodInGram = food * 1000;     // in grams
        double hayInGram = hay * 1000;
        double coverInGram = cover * 1000;
        double weightInGram = weight * 1000;
        boolean isOutOfProvision = false;

        for (int i = 1; i <= 30; i++) {                                 // month (30 days)
            if (foodInGram < 0 || hayInGram < 0 || coverInGram < 0) {   // If one of the things is not enough, print:
                System.out.println("Merry must go to the pet store!");
                isOutOfProvision = true;
                break;
            }
            foodInGram -= 300;                    // Every day Puppy eats 300 gr of food
            if (i % 2 == 0) {                     // Every second day !!!
                hayInGram -= foodInGram * 0.05;   // certain amount of hay equal to 5% of the rest of the food
            }
            if (i % 3 == 0) {                     // On every third day !!!
                coverInGram -= weightInGram / 3;
            }
        }
        if (!isOutOfProvision) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                    foodInGram / 1000, hayInGram / 1000, coverInGram / 1000);
        }

    }
}
