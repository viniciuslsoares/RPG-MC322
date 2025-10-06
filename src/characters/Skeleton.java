package characters;

public class Skeleton extends Monster {
    public Skeleton() {
        super("Skeleton", 50, 10, 25);
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " shoots a dark arrow!");
        target.takeDamage(strength);
    }
}
