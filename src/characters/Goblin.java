package characters;

import java.util.Random;

public class Goblin extends Monster {
    private int agility; 
    private Random random = new Random();

    public Goblin() {
        super("Goblin", 50, 8, 20);
        this.agility = 30; // % chance to dodge an attack
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " stabs wildly with a rusty dagger!");
        target.takeDamage(strength);
    }

    public boolean tryDodge() {
        boolean dodged = random.nextInt(100) < agility;
        if (dodged)
            System.out.println(name + " swiftly dodged the attack!");
        return dodged;
    }

    @Override
    public void takeDamage(int damage) {
        if (tryDodge()) return; 
        super.takeDamage(damage);
    }
}
