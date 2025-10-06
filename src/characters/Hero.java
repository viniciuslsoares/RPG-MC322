package characters;

public abstract class Hero extends Character {
    protected int level;
    protected int experience;

    public Hero(String name, int healthPoints, int strength, int level) {
        super(name, healthPoints, strength);
        this.level = level;
        this.experience = 0;
    }

    public void gainExperience(int xp) {
        experience += xp;
        System.out.println(name + " gained " + xp + " XP!");
    }

    @Override
    public void showStatus() {
        System.out.println("[" + name + "] HP: " + healthPoints + 
                           " | Strength: " + strength +
                           " | Level: " + level +
                           " | XP: " + experience);
    }

    public abstract void useSpecialAbility(Character target);
}
