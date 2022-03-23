
package DEMO.EXAMS_Final.Exam4;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesOfCode2_2MAPs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());         // 73/100
        Map<String, Integer> heroesHit = new TreeMap<>();
        Map<String, Integer> heroesMana = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int hp = Integer.parseInt(tokens[1]);  // hp - index 0
            int mp = Integer.parseInt(tokens[2]);

            heroesHit.put(name, hp);     // diff with 1 MAP -> heroList.get(name).add(hp);
            heroesMana.put(name, mp);
        }
        String input2 = scanner.nextLine();
        while (!input2.equals("End")) {
            String[] tokens2 = input2.split(" - ");
            String command = tokens2[0];
            String name = tokens2[1];
            switch (command) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(tokens2[2]); // mp -index 1 if 1 MAP
                    String spellName = tokens2[3];
                    // I can make the magic/spell, if current >=needed
                    int realMP = heroesMana.get(name);   // diff 1 MAP -> heroList.get(name).get(1);
                    if (realMP > neededMP) {             // real==current
                        realMP -= neededMP;
                        heroesMana.put(name, realMP);    // diff 1 MAP -> heroList.get(name).set(0, hpReal);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, spellName, realMP);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", name, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damageHP = Integer.parseInt(tokens2[2]); // hp -index 0
                    String attacker = tokens2[3];
                    int realHP = heroesHit.get(name);   // 1 MAP -> heroList.get(name).get(0);
                    realHP -= damageHP;
                    heroesHit.put(name, realHP);        // 1 MAP -> heroList.get(name).set(0,currentHP);
                    if (realHP > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", name, damageHP, attacker, realHP);
                    } else {
                        heroesHit.remove(name);
                        System.out.printf("%s has been killed by %s!%n", name, attacker);
                    }
                    break;
                case "Recharge":   // mp
                    int amountMP = Integer.parseInt(tokens2[2]);
                    int currentMP = heroesMana.get(name);
                    if (currentMP + amountMP > 200) {
                        amountMP = 200 - currentMP;  //amountMP+currentMP=200
                    }
                    currentMP += amountMP;
                    heroesMana.put(name, currentMP);
                    System.out.printf("%s recharged for %d MP!%n", name, amountMP);

                    break;
                case "Heal":    //hp
                    int amountHP = Integer.parseInt(tokens2[2]);  // index 0
                    int currentHP = heroesHit.get(name);
                    if (currentHP + amountHP > 100) {
                        amountHP = 100 - currentHP;
                    }
                    currentHP += amountHP;
                    heroesHit.put(name, currentHP);
                    System.out.printf("%s healed for %d HP!%n", name, amountHP);
                    break;
            }
            input2 = scanner.nextLine();
        }
        // sorted by their HP in descending order, then by their name in ascending order,
        heroesHit.entrySet()
                .stream()
                .sorted((f, s) -> {          //sorted by their HP in descending order
                    int result = s.getValue() - f.getValue();
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                }).forEach(hero -> {
                    System.out.println(hero.getKey());
                    System.out.printf(" HP: %d%n", hero.getValue());                // hp   -> diff 1 MAP
                    System.out.printf(" MP: %d%n", heroesMana.get(hero.getKey()));  // mp -> heroesMana.get()  -> diff 1 MAP
                });

        //•	Print all members of your party who are still alive, in the following format
        heroesHit.entrySet()
                .stream()
                .forEach(hero -> {
                    System.out.println(hero.getKey());
                    System.out.printf(" HP: %d%n", hero.getValue());                // hp   -> diff 1 MAP
                    System.out.printf(" MP: %d%n", heroesMana.get(hero.getKey()));  // mp -> heroesMana.get()  -> diff 1 MAP
                });


    }
}
