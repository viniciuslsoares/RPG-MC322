package characters;

import weapons.Weapon;
import java.util.Random;

public abstract class Hero extends Character {
    protected int level;
    protected int experience;
    protected int expToNextLevel;
    protected double luck; // 0–1 random factor
    private Random random = new Random();

    public Hero(String name, int hp, int str, int level) {
        super(name, hp, str);
        this.level = level;
        this.experience = 0;
        this.expToNextLevel = 50;
        this.luck = 0.3 + random.nextDouble() * 0.4; // 0.3–0.7
    }

    public double getLuck() {
        return luck;
    }    

    public void gainExperience(int xp) {
        experience += xp;
        System.out.println(name + " gained " + xp + " XP!");
        if (experience >= expToNextLevel) levelUp();
    }

    private void levelUp() {
        experience -= expToNextLevel;
        level++;
        expToNextLevel += 30;
        strength += 5;
        healthPoints += 20;
        System.out.println("*** " + name + " leveled up to " + level + "! ***");
    }

    public void tryEquipWeapon(Weapon newWeapon) {
        if (newWeapon.getMinLevel() <= level) {
            System.out.println(name + " decides to equip the " + newWeapon.getName() + ".");
            equipWeapon(newWeapon);
        } else {
            System.out.println(name + " is not high enough level to use " + newWeapon.getName() + ".");
        }
    }

    @Override
    public void showStatus() {
        System.out.print("[" + name + "] HP: " + healthPoints + 
                         " | STR: " + strength +
                         " | LVL: " + level +
                         " | XP: " + experience + "/" + expToNextLevel +
                         " | Luck: " + String.format("%.2f", luck));
        if (weapon != null) System.out.print(" | Weapon: " + weapon.getName());
        System.out.println();
    }

    public abstract void useSpecialAbility(Character target);
}
