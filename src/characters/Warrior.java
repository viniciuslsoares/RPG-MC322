package characters;

import java.util.Random;

public class Warrior extends Hero {
    private int rage;

    public Warrior(String name) {
        super(name, 120, 15, 1);
        this.rage = 0;
    }

    @Override
    public void attack(Character target) {
        int damage = totalDamage();
        System.out.println(name + " slashes " + target.getName() + " for " + damage + " damage!");
        target.takeDamage(damage);
        rage += 10;
    }

    @Override
    public void useSpecialAbility(Character target) {
        Random rand = new Random();
        if (rand.nextDouble() < luck) {
            System.out.println(name + " enters a FURY state and lands a critical hit!");
            target.takeDamage(totalDamage() * 2);
        } else {
            System.out.println(name + " swings wildly but misses!");
        }
        rage = 0;
    }
}
