import characters.*;
import world.*;
import weapons.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HERO'S ADVENTURE BEGINS ===");

        Warrior hero = new Warrior("Arthas", 300, 50);
        hero.equipWeapon(new Sword());

        List<Phase> phases = SceneBuilder.generatePhases(3);
        Random rand = new Random();

        for (Phase phase : phases) {
            System.out.println("\n=== ENTERING PHASE " + phase.getLevel() +
                               " — " + phase.getEnvironment().toUpperCase() + " ===");
            hero.showStatus();

            for (Monster monster : phase.getMonsters()) {
                System.out.println("\n--- A " + monster.getName() + " appears! ---");

                while (hero.isAlive() && monster.isAlive()) {
                    hero.attack(monster);
                    if (!monster.isAlive()) break;
                    monster.attack(hero);
                }

                if (!hero.isAlive()) {
                    System.out.println("\nGAME OVER! The hero was defeated by " + monster.getName() + ".");
                    return;
                }

                System.out.println(monster.getName() + " was defeated!");
                hero.gainExperience(monster.getXpGranted());

                // Chance to drop a weapon based on hero luck
                if (rand.nextDouble() < hero.getLuck()) {
                    Weapon drop = monster.dropWeapon();
                    if (drop != null) {
                        System.out.println("The " + monster.getName() + " dropped a " + drop.getName() + "!");
                        hero.tryEquipWeapon(drop);
                    }
                }
            }
            System.out.println("=== Phase " + phase.getLevel() + " cleared! ===");
        }

        System.out.println("\n*** VICTORY! The hero survived all phases! ***");
    }
}
