package characters;

public class Skeleton extends Monster {
    private int boneArmor; 

    public Skeleton() {
        super("Skeleton", 60, 10, 25);
        this.boneArmor = 3; // flat damage reduction
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " shoots a dark arrow!");
        target.takeDamage(strength);
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = Math.max(damage - boneArmor, 0);
        System.out.println(name + "'s bone armor absorbs " + boneArmor + " damage!");
        super.takeDamage(reducedDamage);
    }
}
