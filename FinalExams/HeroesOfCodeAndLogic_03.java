
package DEMO.EXAMS_Final.Exam4;

import java.util.*;

public class HeroesOfCodeAndLogic_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    // 73/100

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroList = new LinkedHashMap<>(); // LinkedHash sorts name by input number

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int hp = Integer.parseInt(input[1]);
            int mp = Integer.parseInt(input[2]);
            heroList.put(name, new ArrayList<>());
            heroList.get(name).add(hp);    // HP - set(0, )
            heroList.get(name).add(mp);    // MP - set(1, )
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split(" - ");
            String commandName = tokens[0];
            String name = tokens[1];
            switch (commandName) {
                case "CastSpell":    // MP
                    int mpNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    int hpReal = heroList.get(name).get(0);
                    int mpReal = heroList.get(name).get(1);
                    if (mpReal >= mpNeeded) {       //If the hero has the required MP
                        mpReal -= mpNeeded;        //thus reducing his MP
                        heroList.get(name).set(0, hpReal);
                        heroList.get(name).set(1, mpReal);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, spellName, mpReal);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", name, spellName);
                    }
                    break;
                case "TakeDamage":   // HP
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    int currentHP = heroList.get(name).get(0);
                    currentHP -= damage;    //	Reduce the hero HP by the given damage amount
                    heroList.get(name).set(0,currentHP);
                    if (currentHP > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", name, damage, attacker, currentHP);
                    } else {
                        heroList.remove(name); // remove him
                        System.out.printf("%s has been killed by %s!%n", name, attacker);
                    }
                    break;
                case "Recharge":  // MP
                    int amountRecharge = Integer.parseInt(tokens[2]);  // MP
                    int momentMP = heroList.get(name).get(1);  //take from For-loop
                    if (momentMP + amountRecharge > 200) {   // !!! > (not =)
                        amountRecharge = 200 - momentMP;
                    }
                    momentMP += amountRecharge;  // in "Need for Speed" code is before the IF check; here not working
                    heroList.get(name).set(1, momentMP);
                    System.out.printf("%s recharged for %d MP!%n", name, amountRecharge);

                    break;
                case "Heal":   //HP
                    int amountHeal = Integer.parseInt(tokens[2]);    // HP
                    int momentHP = heroList.get(name).get(0);
                    if (momentHP + amountHeal > 100) {  // !!! > (not =)
                        amountHeal = 100 - momentHP;
                    }
                    momentHP += amountHeal; // in "Need for Speed" code is before the IF check; here not working
                    heroList.get(name).set(0, momentHP);
                    System.out.printf("%s healed for %d HP!%n", name, amountHeal);

                    break;
            }
            command = scanner.nextLine();
        }
        //sorted by their HP in descending order, then by their name in ascending order
        heroList.entrySet()
                .stream()
                .sorted((f, s) -> {          //sorted by their HP in descending order
                    int result = s.getValue().get(0) - f.getValue().get(0);
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey()); // name in ascending order
                    }
                    return result;
                }).forEach(hero -> {
                    System.out.println(hero.getKey());
                    System.out.printf(" HP: %d%n", hero.getValue().get(0));
                    System.out.printf(" MP: %d%n", hero.getValue().get(1));
                });

//        heroList.entrySet()
//                .stream()
//                .forEach(hero -> {
//                    System.out.println(hero.getKey());
//                    System.out.printf(" HP: %d%n", hero.getValue().get(0));
//                    System.out.printf(" MP: %d%n", hero.getValue().get(1));
//                });

    }
}
