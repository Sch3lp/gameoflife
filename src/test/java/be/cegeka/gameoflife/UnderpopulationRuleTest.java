package be.cegeka.gameoflife;

import org.junit.Test;

import java.util.List;

import static be.cegeka.gameoflife.Cell.dead;
import static be.cegeka.gameoflife.Cell.live;
import static be.cegeka.gameoflife.UnderpopulationRule.DEATH;
import static be.cegeka.gameoflife.UnderpopulationRule.NOTHING;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

public class UnderpopulationRuleTest {

    @Test
    public void apply_LiveCellWithoutNeighbours_Death() throws Exception {
        Cell liveCell = live();
        List<Cell> liveNeighbours = emptyList();

        String outcome = new UnderpopulationRule().apply(liveCell, liveNeighbours);

        assertThat(outcome).isEqualTo(DEATH);
    }

    @Test
    public void apply_LiveCellWithExactlyOneNeighbour_Death() throws Exception {
        Cell liveCell = live();
        List<Cell> liveNeighbours = asList(live());

        String outcome = new UnderpopulationRule().apply(liveCell, liveNeighbours);

        assertThat(outcome).isEqualTo(DEATH);
    }

    @Test
    public void apply_LiveCellWithExactlyTwoNeighbours_Nothing() throws Exception {
        Cell liveCell = live();
        List<Cell> liveNeighbours = asList(live(), live());

        String outcome = new UnderpopulationRule().apply(liveCell, liveNeighbours);

        assertThat(outcome).isEqualTo(NOTHING);
    }

    @Test
    public void apply_DeadCellWithoutNeighbours_Nothing() throws Exception {
        Cell deadCell = dead();
        List<Cell> liveNeighbours = emptyList();

        String outcome = new UnderpopulationRule().apply(deadCell, liveNeighbours);

        assertThat(outcome).isEqualTo(NOTHING);
    }

    @Test
    public void apply_DeadCellWithExactlyOneNeighbour_Nothing() throws Exception {
        Cell deadCell = dead();
        List<Cell> liveNeighbours = asList(live());

        String outcome = new UnderpopulationRule().apply(deadCell, liveNeighbours);

        assertThat(outcome).isEqualTo(NOTHING);
    }

    @Test
    public void apply_DeadCellWithExactlyTwoNeighbours_Nothing() throws Exception {
        Cell deadCell = dead();
        List<Cell> liveNeighbours = asList(live(), live());

        String outcome = new UnderpopulationRule().apply(deadCell, liveNeighbours);

        assertThat(outcome).isEqualTo(NOTHING);
    }
}
