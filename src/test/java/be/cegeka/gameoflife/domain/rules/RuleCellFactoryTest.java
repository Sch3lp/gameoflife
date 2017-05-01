package be.cegeka.gameoflife.domain.rules;

import be.cegeka.gameoflife.domain.Position;
import org.junit.Test;

import static be.cegeka.gameoflife.domain.Cell.dead;
import static be.cegeka.gameoflife.domain.Cell.live;
import static be.cegeka.gameoflife.domain.Position.pos;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

public class RuleCellFactoryTest {

    private RuleCellFactory factory = new RuleCellFactory();

    @Test
    public void createRuleCell_LiveCellWithoutNeighbours() throws Exception {
        RuleCell liveCellWithoutNeighbours = factory.createRuleCell(live(), emptyList(), pos(0,0));
        assertThat(liveCellWithoutNeighbours.isAlive()).isTrue();
        assertThat(liveCellWithoutNeighbours.isDead()).isFalse();
        assertThat(liveCellWithoutNeighbours.amountOfLiveNeighbours()).isEqualTo(0);
    }

    @Test
    public void createRuleCell_DeadCellWithoutNeighbours() throws Exception {
        RuleCell deadCellWithoutNeighbours = factory.createRuleCell(dead(), emptyList(), pos(0,0));

        assertThat(deadCellWithoutNeighbours.isAlive()).isFalse();
        assertThat(deadCellWithoutNeighbours.isDead()).isTrue();
        assertThat(deadCellWithoutNeighbours.amountOfLiveNeighbours()).isEqualTo(0);
    }

    @Test
    public void createRuleCell_CellWith1LiveNeighbour() throws Exception {
        RuleCell cellWith1Neighbour = factory.createRuleCell(live(), asList(dead(), live(), dead()), pos(0,0));

        assertThat(cellWith1Neighbour.amountOfLiveNeighbours()).isEqualTo(1);

    }

    @Test
    public void createRuleCell_CellWith2LiveNeighbours() throws Exception {
        RuleCell cellWithNeighbours = factory.createRuleCell(live(), asList(live(), dead(), live()), pos(0,0));

        assertThat(cellWithNeighbours.amountOfLiveNeighbours()).isEqualTo(2);
    }

    @Test
    public void createRuleCell_CellWithOnlyDeadNeighbours() throws Exception {
        RuleCell cellWithNeighbours = factory.createRuleCell(live(), asList(dead(), dead()), pos(0,0));

        assertThat(cellWithNeighbours.amountOfLiveNeighbours()).isEqualTo(0);
    }
}