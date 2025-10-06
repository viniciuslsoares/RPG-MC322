package characters;

public class Goblin extends Monster {
    public Goblin() {
        super("Goblin", 40, 8, 20);
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " stabs with a rusty dagger!");
        target.takeDamage(strength);
    }
}
