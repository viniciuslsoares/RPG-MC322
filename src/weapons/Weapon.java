package weapons;

public abstract class Weapon {
    protected String name;
    protected int bonusDamage;
    protected int minLevel;

    public Weapon(String name, int bonusDamage, int minLevel) {
        this.name = name;
        this.bonusDamage = bonusDamage;
        this.minLevel = minLevel;
    }

    public String getName() {
        return name;
    }

    public int getBonusDamage() {
        return bonusDamage;
    }

    public int getMinLevel() {
        return minLevel;
    }

    @Override
    public String toString() {
        return name + " (+" + bonusDamage + " dmg, min lvl " + minLevel + ")";
    }
}
