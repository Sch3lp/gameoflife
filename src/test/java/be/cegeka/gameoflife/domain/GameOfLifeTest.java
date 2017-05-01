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
}
