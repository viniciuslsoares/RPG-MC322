package world;

import java.util.*;
import characters.*;
import weapons.*;

public class SceneBuilder {

    public static List<Phase> generatePhases(int numPhases) {
        List<Phase> phases = new ArrayList<>();
        Random rand = new Random();

        for (int i = 1; i <= numPhases; i++) {
            List<Monster> monsters = new ArrayList<>();

            for (int j = 0; j < 2 + i; j++) {
                Monster m;
                switch (rand.nextInt(3)) {
                    case 0 -> m = new Goblin();
                    case 1 -> m = new Skeleton();
                    default -> m = new Ghost();
                }
                // Scale difficulty
                m.updateHealthPoints(i * 15);
                m.updateStrength(i * 5);
                m.addDrop(new Sword());
                m.addDrop(new Axe());
                m.addDrop(new Bow());
                monsters.add(m);
            }

            String env = switch (i) {
                case 1 -> "Forest of Beginnings";
                case 2 -> "Ruins of Shadows";
                default -> "Cursed Fortress";
            };

            phases.add(new Phase(i, env, monsters));
        }
        return phases;
    }
}
