package characters;

public class Warrior extends Hero {
    private int rage;

    public Warrior(String name) {
        super(name, 120, 15, 1);
        this.rage = 0;
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " strikes " + target.name + " with a sword slash!");
        target.takeDamage(strength);
        rage += 10;
    }

    @Override
    public void useSpecialAbility(Character target) {
        System.out.println(name + " uses FURIOUS STRIKE!");
        int damage = strength + rage / 2;
        target.takeDamage(damage);
        rage = 0;
    }
}
