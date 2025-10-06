package characters;

public abstract class Character {
    protected String name;
    protected int healthPoints;
    protected int strength;

    public Character(String name, int healthPoints, int strength) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void takeDamage(int damage) {
        healthPoints -= damage;
        if (healthPoints < 0) healthPoints = 0;
        System.out.println(name + " took " + damage + " damage!");
    }

    public void showStatus() {
        System.out.println("[" + name + "] HP: " + healthPoints + " | Strength: " + strength);
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public abstract void attack(Character target);
}
