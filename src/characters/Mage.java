package characters;

import java.util.Random;

public class Mage extends Hero {
    private int mana;
    private int basicAttack;

    public Mage(String name, int hp, int str) {
        super(name, hp, str, 1);
        this.mana = 100;
        this.basicAttack = 10;
    }

    @Override
    public void attack(Character target) {
        int damage = 0;
        if (mana >= 10) {
            damage = totalDamage();
            System.out.println(name + " casts a spell at " + target.getName() + " for " + damage + " damage!");
            mana -= 10;
        } else {
            System.out.println(name + " doesn't have enough mana!");
            System.out.println(name + " casts a basic attack at " + target.getName() + " for " + basicAttack + " damage!");

        }
            target.takeDamage(basicAttack);

    }

    @Override
    public void useSpecialAbility(Character target) {
        Random rand = new Random();
        if (mana >= 20) {
            if (rand.nextDouble() < luck) {
                System.out.println(name + " channels a FIRESTORM! Critical magic hit!");
                target.takeDamage(totalDamage() * 2);
            } else {
                System.out.println(name + " miscasts the spell and it fizzles!");
            }
            mana -= 20;
        } else {
            System.out.println(name + " doesn't have enough mana!");
        }
    }
}
