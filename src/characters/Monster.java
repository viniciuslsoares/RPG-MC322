package characters;

public abstract class Monster extends Character {
    protected int xpGranted;

    public Monster(String name, int healthPoints, int strength, int xpGranted) {
        super(name, healthPoints, strength);
        this.xpGranted = xpGranted;
    }

    public int getXpGranted() {
        return xpGranted;
    }

    @Override
    public void showStatus() {
        System.out.println("[" + name + "] HP: " + healthPoints + 
                           " | Strength: " + strength +
                           " | XP Granted: " + xpGranted);
    }
}
