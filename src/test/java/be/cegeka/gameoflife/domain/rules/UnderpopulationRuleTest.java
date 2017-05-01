package be.cegeka.gameoflife.domain.rules;

import be.cegeka.gameoflife.domain.Cell;
import org.junit.Test;

import java.util.List;

import static be.cegeka.gameoflife.domain.Cell.dead;
import static be.cegeka.gameoflife.domain.Cell.live;
import static be.cegeka.gameoflife.domain.rules.RuleCellTestBuilder.aLiveRuleCell;
import static be.cegeka.gameoflife.domain.rules.UnderpopulationRule.DEATH;
import static be.cegeka.gameoflife.domain.rules.UnderpopulationRule.NOTHING;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

public class UnderpopulationRuleTest {

    @Test
    public void apply_LiveCellWithoutNeighbours_Death() throws Exception {
        RuleCell cell = aLiveRuleCell().withoutNeighbours().build();
        String outcome = new UnderpopulationRule().apply(cell);

        assertThat(outcome).isEqualTo(DEATH);
    }

    @Test
    public void apply_LiveCellWithExactlyOneNeighbour_Death() throws Exception {
        Cell liveCell = live();
        List<Cell> liveNeighbours = asList(live());

        RuleCell ruleCell = createRuleCell(liveCell, liveNeighbours);
        String outcome = new UnderpopulationRule().apply(ruleCell);

        assertThat(outcome).isEqualTo(DEATH);
    }

    @Test
    public void apply_LiveCellWithExactlyTwoNeighbours_Nothing() throws Exception {
        Cell liveCell = live();
        List<Cell> liveNeighbours = asList(live(), live());

        RuleCell ruleCell = createRuleCell(liveCell, liveNeighbours);
        String outcome = new UnderpopulationRule().apply(ruleCell);

        assertThat(outcome).isEqualTo(NOTHING);
    }

    @Test
    public void apply_DeadCellWithoutNeighbours_Nothing() throws Exception {
        Cell deadCell = dead();
        List<Cell> liveNeighbours = emptyList();

        RuleCell ruleCell = createRuleCell(deadCell, liveNeighbours);
        String outcome = new UnderpopulationRule().apply(ruleCell);

        assertThat(outcome).isEqualTo(NOTHING);
    }

    @Test
    public void apply_DeadCellWithExactlyOneNeighbour_Nothing() throws Exception {
        Cell deadCell = dead();
        List<Cell> liveNeighbours = asList(live());

        RuleCell ruleCell = createRuleCell(deadCell, liveNeighbours);
        String outcome = new UnderpopulationRule().apply(ruleCell);

        assertThat(outcome).isEqualTo(NOTHING);
    }

    @Test
    public void apply_DeadCellWithExactlyTwoNeighbours_Nothing() throws Exception {
        Cell deadCell = dead();
        List<Cell> liveNeighbours = asList(live(), live());

        RuleCell ruleCell = createRuleCell(deadCell, liveNeighbours);
        String outcome = new UnderpopulationRule().apply(ruleCell);

        assertThat(outcome).isEqualTo(NOTHING);
    }

    private RuleCell createRuleCell(Cell liveCell, List<Cell> liveNeighbours) {
        return new RuleCellFactory().createRuleCell(liveCell, liveNeighbours);
    }
}
