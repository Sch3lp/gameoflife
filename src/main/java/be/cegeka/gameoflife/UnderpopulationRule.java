package be.cegeka.gameoflife;

import java.util.List;

public class UnderpopulationRule {

    public static final String DEATH = "Death";
    public static final String NOTHING = "Nothing";

    public String apply(Cell cell, List<Cell> liveNeighbours) {
        if (cell.isDead()) return NOTHING;
        if (liveNeighbours.size() >= 2) return NOTHING;
        return DEATH;
    }
}
