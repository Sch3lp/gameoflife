package be.cegeka.gameoflife.domain;

import org.junit.Test;

import static be.cegeka.gameoflife.domain.Cell.dead;
import static be.cegeka.gameoflife.domain.Cell.live;
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

        assertThat(world.tick().as2DList()).containsExactly(
                asList(dead(), dead(), live()),
                asList(dead(), live(), live()),
                asList(dead(), dead(), live())
        );
    }

    @Test
    public void multipleLiveCellsWithFewerThanTwoLiveNeighboursDies() throws Exception {
        Generation world = Generation.of(
                asList(dead(), dead(), dead(), live(), live()),
                asList(dead(), live(), dead(), live(), live()),
                asList(live(), dead(), live(), live(), live()),
                asList(dead(), dead(), dead(), live(), live()),
                asList(dead(), dead(), dead(), live(), live())
        );

        assertThat(world.tick().as2DList()).containsExactly(
                asList(dead(), dead(), dead(), live(), live()),
                asList(dead(), live(), dead(), live(), live()),
                asList(dead(), dead(), live(), live(), live()),
                asList(dead(), dead(), dead(), live(), live()),
                asList(dead(), dead(), dead(), live(), live())
        );
    }

    @Test
    public void rowOfLiveCells_OuterLiveCellsShouldDie() throws Exception {
        Generation world = Generation.of(
                asList(dead(), dead(), dead()),
                asList(live(), live(), live()),
                asList(dead(), dead(), dead())
        );

        assertThat(world.tick().as2DList()).containsExactly(
                asList(dead(), dead(), dead()),
                asList(dead(), live(), dead()),
                asList(dead(), dead(), dead())
        );
    }
}
