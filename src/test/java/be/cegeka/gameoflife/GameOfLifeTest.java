package be.cegeka.gameoflife;

import org.junit.Test;

import java.util.List;

import static be.cegeka.gameoflife.Cell.dead;
import static be.cegeka.gameoflife.Cell.live;
import static be.cegeka.gameoflife.Position.pos;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class GameOfLifeTest {

    @Test
    public void liveCellWithFewerThanTwoLiveNeighboursDies() throws Exception {
        Generation world = Generation.of(
                asList(dead(), dead(), live()),
                asList(live(), live(), live()),
                asList(dead(), dead(), live())
        );

        assertThat(tick(world).as2DList()).containsExactly(
                asList(dead(), dead(), live()),
                asList(dead(), live(), live()),
                asList(dead(), dead(), live())
        );
    }

    private Generation tick(Generation world) {
        Position posOfCellUnderTest = pos(1, 0);
        Cell cellUnderTest = world.cellAt(posOfCellUnderTest);
        String outcome = underpopulationRuleOutcome(cellUnderTest, world.getLiveNeighbours(posOfCellUnderTest));
        if ("death".equals(outcome)) {
            cellUnderTest.kill();
        }
        return world;
    }

    private String underpopulationRuleOutcome(Cell cell, List<Cell> liveNeighbours) {
        return new UnderpopulationRuleStub().apply(cell, liveNeighbours);
    }

    private class UnderpopulationRuleStub extends UnderpopulationRule {
        public String apply(Cell cell, List<Cell> liveNeighbours) {
            return "death";
        }
    }
}
