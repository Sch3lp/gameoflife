package be.cegeka.gameoflife;

import java.util.List;

public class UnderpopulationRule {

    public String apply(Cell cell, List<Cell> liveNeighbours) {
        if (cell.isDead()) return "";
        if (liveNeighbours.size() >= 2) return "";
        return "Death";
    }
}
