package be.cegeka.gameoflife;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UnderpopulationRuleTest {

    @Test
    public void liveCellWithFewerThanTwoLiveNeighboursDies() throws Exception {
        Cell cell = Cell.dead();
        List<Cell> liveNeighbours = Collections.emptyList();

        String outcome = new UnderpopulationRule().apply(cell, liveNeighbours);

        assertThat(outcome).isEqualTo("death");
    }
}