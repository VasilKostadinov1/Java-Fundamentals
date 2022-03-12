package DEMO.TextProcessingMoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split("\\s*,\\s*");
        String regex = "(?=.{20}).*?(?=(?<ch>[@#$^]))(?<match>\\k<ch>{6,}).*(?<=.{10})\\k<match>.*"; // !!! *? Lazy ; * Greedy

        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(ticket);
                if (matcher.matches()) {
                    String match = matcher.group("match");
                    if (match.length() == 10) {
                        System.out.printf("ticket \"%s\" - %d%s Jackpot!%n",
                                ticket, match.length(), match.charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - %d%s %n",
                                ticket, match.length(), match.charAt(0));
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }
            }
        }
        //*? matches the previous token between zero and unlimited times, as few times as possible, expanding as needed (lazy)




    }
}
