package be.cegeka.gameoflife;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class UnderpopulationRuleTest {

    @Test
    public void liveCellWithFewerThanTwoLiveNeighboursDies() throws Exception {
        Cell cell = Cell.dead();
        List<Cell> liveNeighbours = Collections.emptyList();
        new UnderpopulationRule().apply(cell, liveNeighbours);
    }
}