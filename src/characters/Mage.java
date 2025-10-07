package characters;

import java.util.Random;

public class Mage extends Hero {
    private int mana;

    public Mage(String name, int hp, int str) {
        super(name, hp, str, 1);
        this.mana = 100;
    }

    @Override
    public void attack(Character target) {
        int damage = totalDamage();
        System.out.println(name + " casts a spell at " + target.getName() + " for " + damage + " damage!");
        target.takeDamage(damage);
        mana -= 10;
    }

    @Override
    public void useSpecialAbility(Character target) {
        Random rand = new Random();
        if (mana >= 20) {
            if (rand.nextDouble() < luck) {
                System.out.println(name + " channels a FIRESTORM! Critical magic hit!");
                target.takeDamage(totalDamage() * 3);
            } else {
                System.out.println(name + " miscasts the spell and it fizzles!");
            }
            mana -= 20;
        } else {
            System.out.println(name + " doesn't have enough mana!");
        }
    }
}
