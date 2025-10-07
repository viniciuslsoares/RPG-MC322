package characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import weapons.Weapon;

public abstract class Monster extends Character {
    protected int xpGranted;
    protected List<Weapon> weaponDrops = new ArrayList<>();

    public Monster(String name, int hp, int str, int xpGranted) {
        super(name, hp, str);
        this.xpGranted = xpGranted;
    }

    public int getXpGranted() { return xpGranted; }

    public void addDrop(Weapon weapon) {
        weaponDrops.add(weapon);
    }

    public Weapon dropWeapon() {
        if (weaponDrops.isEmpty()) return null;
        Random rand = new Random();
        return weaponDrops.get(rand.nextInt(weaponDrops.size()));
    }

    @Override
    public void showStatus() {
        System.out.println("[" + name + "] HP: " + healthPoints + 
                           " | STR: " + strength +
                           " | XP Granted: " + xpGranted);
    }
}
