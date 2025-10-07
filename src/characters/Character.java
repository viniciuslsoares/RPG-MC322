package characters;

import weapons.Weapon;

public abstract class Character {
    protected String name;
    protected int healthPoints;
    protected int strength;
    protected Weapon weapon;

    public Character(String name, int healthPoints, int strength) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
    }

    public int getStrength() { return strength; }
    public void setStrength(int newStrength) { strength = newStrength; }
    public void updateStrength(int addedStrength) { strength += addedStrength;}

    public int getHealthPoints() { return healthPoints; }
    public void getHealthPoints(int newHealthPoints) { healthPoints = newHealthPoints; }    
    public void updateHealthPoints(int addedHealthPoints) { healthPoints += addedHealthPoints;}

    public String getName() { return name; }
    public boolean isAlive() { return healthPoints > 0; }

    public void takeDamage(int damage) {
        healthPoints -= damage;
        if (healthPoints < 0) healthPoints = 0;
        System.out.println(name + " took " + damage + " damage!");
    }

    public void showStatus() {
        System.out.print("[" + name + "] HP: " + healthPoints + " | STR: " + strength);
        if (weapon != null) System.out.print(" | Weapon: " + weapon.getName());
        System.out.println();
    }

    public void equipWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
        System.out.println(name + " equipped " + newWeapon.getName() + "!");
    }

    protected int totalDamage() {
        return strength + (weapon != null ? weapon.getBonusDamage() : 0);
    }

    public abstract void attack(Character target);
}
