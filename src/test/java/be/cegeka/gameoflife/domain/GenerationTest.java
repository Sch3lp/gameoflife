package be.cegeka.gameoflife.domain;

import be.cegeka.gameoflife.domain.Generation;
import org.junit.Test;

import static be.cegeka.gameoflife.domain.Cell.dead;
import static be.cegeka.gameoflife.domain.Cell.live;
import static be.cegeka.gameoflife.domain.Position.pos;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class GenerationTest {

    @Test
    public void getLiveNeighbours_NoCellAtPosition_ReturnsEmptyList() throws Exception {
        Generation generationWithOneCell = Generation.of(asList(dead()));
        assertThat(generationWithOneCell.getLiveNeighbours(pos(0,1))).isEmpty();
    }

    @Test
    public void getLiveNeighbours_CellAtPositionHasOnlyLiveNeighbours_ReturnsAllNeighbourCells() throws Exception {
        Generation generationWithOnlyLiveCells = Generation.of
                ( asList(live(), live(), live())
                , asList(live(), live(), live())
                , asList(live(), live(), live())
                );
        assertThat(generationWithOnlyLiveCells.getLiveNeighbours(pos(1,1))).hasSize(8);
    }

    @Test
    public void getLiveNeighbours_CellAtPositionHasOnlyDeadNeighbours_ReturnsEmptyList() throws Exception {
        Generation generationWithOnlyLiveCells = Generation.of
                ( asList(dead(), dead(), dead())
                , asList(dead(), live(), dead())
                , asList(dead(), dead(), dead())
                );
        assertThat(generationWithOnlyLiveCells.getLiveNeighbours(pos(1,1))).isEmpty();
    }

    @Test
    public void getLiveNeighbours_CellAtPositionHasACoupleOfNonExistingNeighbours_ReturnsOnlyLiveNeighbours() throws Exception {
        Generation generationWithOnlyLiveCells = Generation.of
                ( asList(live(), live())
                , asList(live(), live())
                );
        assertThat(generationWithOnlyLiveCells.getLiveNeighbours(pos(1,1))).hasSize(3);
    }

    @Test
    public void cellAt_NoCellAtPosition_ReturnsNull() throws Exception {
        Generation generationWithOneRow = Generation.of(asList(live(), live(), live()));
        assertThat(generationWithOneRow.cellAt(pos(1, 0))).isNull();
    }

    @Test
    public void cellAt_CellAtPosition_ReturnsCell() throws Exception {
        Generation generation = Generation.of
                ( asList(live(), live(), live())
                , asList(dead(), live(), live())
                , asList(live(), live(), live())
                );
        assertThat(generation.cellAt(pos(1, 0))).isEqualTo(dead());
    }

    @Test
    public void cellAt_NegativeX_ReturnsNull() throws Exception {
        Generation generation = Generation.of(asList(live(), live(), live()));
        assertThat(generation.cellAt(pos(-1, 0))).isNull();
    }

    @Test
    public void cellAt_NegativeY_ReturnsNull() throws Exception {
        Generation generation = Generation.of(asList(live(), live(), live()));
        assertThat(generation.cellAt(pos(0, -1))).isNull();
    }
}