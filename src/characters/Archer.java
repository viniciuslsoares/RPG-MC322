package characters;

import java.util.Random;

public class Archer extends Hero {
    private int arrows;        
    private double precision;  
    private Random random = new Random();

    public Archer(String name, int hp, int str, int arrows, float precision) {
        super(name, hp, str, 1);
        this.arrows = arrows;           
        this.precision = precision;      
    }

    @Override
    public void attack(Character target) {
        if (arrows <= 0) {
            System.out.println(name + " is out of arrows and must restock!");
            return;
        }

        arrows--;
        System.out.println(name + " fires an arrow at " + target.getName() + "!");

        if (random.nextDouble() < precision) {
            int damage = totalDamage();
            System.out.println("The arrow hits for " + damage + " damage!");
            target.takeDamage(damage);
        } else {
            System.out.println(name + " misses the shot!");
        }
    }

    @Override
    public void useSpecialAbility(Character target) {
        if (arrows < 3) {
            System.out.println(name + " doesn't have enough arrows for a Rain of Arrows!");
            return;
        }

        arrows -= 3;
        System.out.println(name + " unleashes a RAIN OF ARROWS on " + target.getName() + "!");
        int hits = 0;

        for (int i = 0; i < 3; i++) {
            if (random.nextDouble() < precision * 0.8) { // less accurate per shot
                hits++;
                int damage = (int) (totalDamage() * 1,25);
                target.takeDamage(damage);
            }
        }

        if (hits == 0)
            System.out.println("All arrows missed!");
        else
            System.out.println(hits + " arrows hit their target!");

        // small chance to recover one arrow after special attack based on luck
        if (random.nextDouble() < getLuck() / 2) {
            arrows++;
            System.out.println(name + " managed to recover one arrow!");
        }
    }


    public void restockArrows() {
        arrows += 20;
        System.out.println(name + " restocked arrows and is ready for battle!");
    }

    @Override
    public void showStatus() {
        System.out.print("[" + name + "] HP: " + healthPoints +
                         " | STR: " + strength +
                         " | LVL: " + level +
                         " | XP: " + experience + "/" + expToNextLevel +
                         " | Luck: " + String.format("%.2f", luck) +
                         " | Arrows: " + arrows);
        if (weapon != null) System.out.print(" | Weapon: " + weapon.getName());
        System.out.println();
    }
}
