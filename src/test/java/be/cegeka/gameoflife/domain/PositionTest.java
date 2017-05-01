package be.cegeka.gameoflife.domain;

import be.cegeka.gameoflife.domain.Position;
import org.junit.Test;

import static be.cegeka.gameoflife.domain.Position.pos;
import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void positionIsImmutable() throws Exception {
        assertThat(pos(0, 0)).isEqualTo(pos(0,0));
    }

    @Test
    public void top() throws Exception {
        Position originalPosition = pos(2, 2);
        assertThat(originalPosition.top()).isEqualTo(pos(1,2));
        assertThat(originalPosition.top().top()).isEqualTo(pos(0,2));
    }

    @Test
    public void bottom() throws Exception {
        Position originalPosition = pos(2, 2);
        assertThat(originalPosition.bottom()).isEqualTo(pos(3,2));
        assertThat(originalPosition.bottom().bottom()).isEqualTo(pos(4,2));
    }

    @Test
    public void left() throws Exception {
        Position originalPosition = pos(2, 2);
        assertThat(originalPosition.left()).isEqualTo(pos(2,1));
        assertThat(originalPosition.left().left()).isEqualTo(pos(2,0));
    }

    @Test
    public void right() throws Exception {
        Position originalPosition = pos(2, 2);
        assertThat(originalPosition.right()).isEqualTo(pos(2,3));
        assertThat(originalPosition.right().right()).isEqualTo(pos(2,4));
    }

    @Test
    public void positionClockNavigation() throws Exception {
        Position originalPosition = pos(2, 2);
        assertThat(originalPosition.top()).isEqualTo(pos(1,2));
        assertThat(originalPosition.top().right()).isEqualTo(pos(1,3));
        assertThat(originalPosition.top().right().bottom()).isEqualTo(pos(2,3));
        assertThat(originalPosition.top().right().bottom().bottom()).isEqualTo(pos(3,3));
        assertThat(originalPosition.top().right().bottom().bottom().left()).isEqualTo(pos(3,2));
        assertThat(originalPosition.top().right().bottom().bottom().left().left()).isEqualTo(pos(3,1));
        assertThat(originalPosition.top().right().bottom().bottom().left().left().top()).isEqualTo(pos(2,1));
        assertThat(originalPosition.top().right().bottom().bottom().left().left().top().top()).isEqualTo(pos(1,1));
        assertThat(originalPosition.top().right().bottom().bottom().left().left().top().top().right()).isEqualTo(pos(1,2));
        assertThat(originalPosition.top().right().bottom().bottom().left().left().top().top().right().bottom()).isEqualTo(originalPosition);
    }
}