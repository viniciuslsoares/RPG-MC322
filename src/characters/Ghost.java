package characters;

import java.util.Random;

public class Ghost extends Monster {
    private int invisibilityTurns; 
    private Random random = new Random();

    public Ghost() {
        super("Ghost", 45, 12, 30);
        this.invisibilityTurns = 0;
    }

    @Override
    public void attack(Character target) {
        if (invisibilityTurns > 0) {
            System.out.println(name + " reappears from the shadows and attacks!");
            invisibilityTurns = 0; 
        }
        System.out.println(name + " releases a wave of cursed energy!");
        target.takeDamage(strength + 5);

        if (random.nextInt(100) < 30) {
            goInvisible();
        }
    }

    /**
     * Unique behavior: can turn invisible and avoid the next attack.
     */
    private void goInvisible() {
        invisibilityTurns = 1;
        System.out.println(name + " fades into the mist and becomes invisible!");
    }

    @Override
    public void takeDamage(int damage) {
        if (invisibilityTurns > 0) {
            System.out.println(name + " is invisible and evades the attack!");
            invisibilityTurns--;
            return;
        }
        super.takeDamage(damage);
    }
}
