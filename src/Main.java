import characters.*;
import world.*;
import weapons.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HERO'S ADVENTURE BEGINS ===");

        Scanner scanner = new Scanner(System.in);
        Hero hero = chooseHero(scanner);

        // Starting weapon based on hero type
        if (hero instanceof Warrior) hero.equipWeapon(new Sword());
        else if (hero instanceof Mage) hero.equipWeapon(new Staff()); // optional: create Staff.java
        else if (hero instanceof Archer) hero.equipWeapon(new Bow());

        List<Phase> phases = SceneBuilder.generatePhases(3);
        Random rand = new Random();

        for (Phase phase : phases) {
            System.out.println("\n=== ENTERING PHASE " + phase.getLevel() +
                               " — " + phase.getEnvironment().toUpperCase() + " ===");
            hero.showStatus();

            for (Monster monster : phase.getMonsters()) {
                System.out.println("\n--- A " + monster.getName() + " appears! ---");

                // battle loop
                while (hero.isAlive() && monster.isAlive()) {
                    hero.attack(monster);
                    if (!monster.isAlive()) break;
                    monster.attack(hero);
                }

                if (!hero.isAlive()) {
                    System.out.println("\n💀 GAME OVER! The hero was defeated by " + monster.getName() + ".");
                    return;
                }

                System.out.println("✅ " + monster.getName() + " was defeated!");
                hero.gainExperience(monster.getXpGranted());

                // Weapon drop chance based on hero luck
                if (rand.nextDouble() < hero.getLuck()) {
                    Weapon drop = monster.dropWeapon();
                    if (drop != null) {
                        System.out.println("💎 The " + monster.getName() + " dropped a " + drop.getName() + "!");
                        hero.tryEquipWeapon(drop);
                    }
                }
            }

            System.out.println("=== PHASE " + phase.getLevel() + " CLEARED! ===");

            // Archer-specific action between phases
            if (hero instanceof Archer archer) {
                archer.restockArrows();
            }
        }

        System.out.println("\n🏆 *** VICTORY! The hero survived all phases! ***");
    }

    private static Hero chooseHero(Scanner scanner) {
        System.out.println("Choose your hero class:");
        System.out.println("1 - Warrior (high HP & melee damage)");
        System.out.println("2 - Mage (magic damage & mana)");
        System.out.println("3 - Archer (ranged precision attacks)");
        System.out.print("> ");

        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ignored) {}

        System.out.print("Enter your hero's name: ");
        String name = scanner.nextLine();

        return switch (choice) {
            case 2 -> new Mage(name, 250, 50);
            case 3 -> new Archer(name, 100, 40, 20);
            default -> new Warrior(name, 200, 30);
        };
    }
}
