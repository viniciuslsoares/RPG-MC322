package characters;

public class Mage extends Hero {
    private int mana;

    public Mage(String name) {
        super(name, 80, 10, 1);
        this.mana = 100;
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " casts a spell at " + target.getName() + "!");
        target.takeDamage(strength);
        mana -= 10;
    }

    @Override
    public void useSpecialAbility(Character target) {
        if (mana >= 30) {
            System.out.println(name + " conjures a FIREBALL!");
            target.takeDamage(strength * 3);
            mana -= 30;
        } else {
            System.out.println(name + " doesn't have enough mana!");
        }
    }
}
