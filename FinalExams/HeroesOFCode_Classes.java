package DEMO.EXAMS_Final.Exam4;

import java.util.*;

public class HeroesOFCode_Classes {
    static class Hero {
        String name;
        int hitPoints;
        int manaPoints;

        public Hero(String name, int hitPoints, int manaPoints) {
            this.name = name;
            this.hitPoints = hitPoints;
            this.manaPoints = manaPoints;
        }

        public String getName() {
            return name;
        }

        public int getHitPoints() {
            return hitPoints;
        }

        public int getManaPoints() {
            return manaPoints;
        }

        public void setManaPoints(int manaPoints) {
            this.manaPoints = manaPoints;
        }

        public void setHitPoints(int hitPoints) {
            this.hitPoints = hitPoints;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Hero> heroes = new LinkedHashMap<>();

        int numHeroes = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numHeroes; i++) {
            String line = scanner.nextLine();
            String[] heroParams = line.split(" ");
            Hero hero = new Hero(heroParams[0], Integer.parseInt(heroParams[1]), Integer.parseInt(heroParams[2]));
            heroes.put(hero.getName(), hero);

        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandParts = command.split(" - ");
            switch (commandParts[0]) {
                case "CastSpell":
                    handleCastSpell(heroes, commandParts[1], Integer.parseInt(commandParts[2]), commandParts[3]);
                    break;
                case "TakeDamage":
                    handleTakeDamage(heroes, commandParts[1], Integer.parseInt(commandParts[2]), commandParts[3]);
                    break;
                case "Recharge":
                    handleRecharge(heroes, commandParts[1], Integer.parseInt(commandParts[2]));
                    break;
                case "Heal":
                    handleHeal(heroes, commandParts[1], Integer.parseInt(commandParts[2]));
                    break;
            }


            command = scanner.nextLine();
        }
        for (Hero hero : heroes.values()) {  // heroes.values = all heroes = Collection
            System.out.println(hero.getName() + System.lineSeparator()
                    + " HP: " + hero.getHitPoints() + System.lineSeparator()
                    + " MP: " + hero.getManaPoints());

        }
    }

    private static void handleHeal(Map<String, Hero> heroes, String heroName, int amount) {
        Hero hero = heroes.get(heroName);

        int oldHitPoints = hero.getHitPoints();
        int newHitPoints = Math.min(hero.getHitPoints() + amount, 100);
        hero.setManaPoints(newHitPoints);
        System.out.printf("%s healed for %d HP!%n", hero.getName(), newHitPoints - oldHitPoints);
    }

    private static void handleRecharge(Map<String, Hero> heroes, String heroName, int amount) {
        Hero hero = heroes.get(heroName);

        int oldManaPoints = hero.getManaPoints();
        int newManaPoints = Math.min(hero.getManaPoints() + amount, 200);
        hero.setManaPoints(newManaPoints);
        System.out.printf("%s recharged for %d MP!%n", hero.getName(), newManaPoints - oldManaPoints);

    }

    private static void handleTakeDamage(Map<String, Hero> heroes, String heroName, int damage, String attacker) {
        Hero hero = heroes.get(heroName);

        hero.setHitPoints(hero.getHitPoints() - damage);
        if (hero.getHitPoints() > 0) {
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", hero.getName(), damage, attacker, hero.getHitPoints());
        } else {
            System.out.printf("%s has been killed by %s!%n", hero.getName(), attacker);
            heroes.remove(heroName);
        }
    }

    private static void handleCastSpell(Map<String, Hero> heroes, String heroName, int manaPoints, String spellName) {
        Hero hero = heroes.get(heroName);

        if (hero.getManaPoints() >= manaPoints) {
            hero.setManaPoints(hero.getManaPoints() - manaPoints);
            System.out.printf("%s has successfully cast %s and now has %d MP!%n", hero.getName(), spellName, hero.getManaPoints());
        } else {
            System.out.printf("%s does not have enough MP to cast %s!%n", hero.getName(), spellName);
        }


    }
}
