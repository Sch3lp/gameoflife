package be.cegeka.gameoflife;

import java.util.List;

public interface UnderpopulationRule {
    String apply(Position cell, List<Cell> liveNeighbours);
}
