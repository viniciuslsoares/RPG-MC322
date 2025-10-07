package world;

import java.util.ArrayList;
import java.util.List;
import characters.Monster;

public class Phase {
    private int level;
    private String environment;
    private List<Monster> monsters;

    public Phase(int level, String environment, List<Monster> monsters) {
        this.level = level;
        this.environment = environment;
        this.monsters = monsters;
    }

    public int getLevel() { return level; }
    public String getEnvironment() { return environment; }
    public List<Monster> getMonsters() { return monsters; }
}
