package characters;

public class Ghost extends Monster {

    public Ghost() {
        super("Ghost", 35, 12, 30);  // name, HP, strength, XP granted
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " releases a wave of cursed energy!");
        target.takeDamage(strength + 5);
    }
}
