import characters.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== THE HERO ENTERS THE DUNGEON ===");

        Warrior hero = new Warrior("Arthas");
        Monster[] monsters = { new Goblin(), 
                                new Skeleton(), 
                                new Ghost() };

        hero.showStatus();
        System.out.println();

        for (int i = 0; i < monsters.length; i++) {
            Monster monster = monsters[i];
            System.out.println("--- TURN " + (i + 1) + " ---");
            System.out.println("A " + monster.getName() + " appears!");

            hero.attack(monster);
            if (monster.isAlive()) {
                monster.attack(hero);
            }

            System.out.println("\nStatus after the turn:");
            hero.showStatus();
            monster.showStatus();
            System.out.println();

            if (!hero.isAlive()) {
                System.out.println("GAME OVER! The hero has fallen.");
                return;
            }

            if (!monster.isAlive()) {
                hero.gainExperience(monster.getXpGranted());
            }
        }

        System.out.println("VICTORY! The hero survived all three encounters!");
    }
}
