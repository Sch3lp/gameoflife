package be.cegeka.gameoflife;

import org.junit.Test;

import static be.cegeka.gameoflife.Cell.dead;
import static be.cegeka.gameoflife.Cell.live;
import static org.assertj.core.api.Assertions.assertThat;

public class CellTest {

    @Test
    public void cellIsEqualToAnotherCellWhenAliveIsTheSame() throws Exception {
        assertThat(live()).isEqualTo(live());
        assertThat(dead()).isEqualTo(dead());
        assertThat(live()).isNotEqualTo(dead());
        assertThat(dead()).isNotEqualTo(live());
    }

    @Test
    public void cellsToString_WhenAliveIsTrue_ThenLive() throws Exception {
        assertThat(live().toString()).isEqualTo("live");
    }

    @Test
    public void cellsToString_WhenAliveIsFalse_ThenDead() throws Exception {
        assertThat(dead().toString()).isEqualTo("dead");
    }

    @Test
    public void isAlive_LiveCell_IsAlive() throws Exception {
        assertThat(live().isAlive()).isTrue();
    }

    @Test
    public void isAlive_DeadCell_IsNotAlive() throws Exception {
        assertThat(dead().isDead()).isTrue();
    }

    @Test
    public void kill_DeadCell_StaysDead() throws Exception {
        Cell cell = dead();
        cell.kill();

        assertThat(cell.isDead()).isTrue();
    }

    @Test
    public void kill_LiveCell_IsNoLongerAlive() throws Exception {
        Cell cell = live();
        cell.kill();

        assertThat(cell.isAlive()).isFalse();
    }
}
