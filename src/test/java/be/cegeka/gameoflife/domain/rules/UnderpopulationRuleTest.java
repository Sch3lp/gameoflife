package be.cegeka.gameoflife.domain.rules;

import org.junit.Before;
import org.junit.Test;

import static be.cegeka.gameoflife.domain.rules.RuleCellTestBuilder.aDeadRuleCell;
import static be.cegeka.gameoflife.domain.rules.RuleCellTestBuilder.aLiveRuleCell;
import static be.cegeka.gameoflife.domain.rules.UnderpopulationRule.DEATH;
import static be.cegeka.gameoflife.domain.rules.UnderpopulationRule.NOTHING;
import static org.assertj.core.api.Assertions.assertThat;

public class UnderpopulationRuleTest {

    private UnderpopulationRule underpopulationRule;

    @Before
    public void setUp() throws Exception {
        underpopulationRule = new UnderpopulationRule();
    }

    @Test
    public void apply_LiveCellWithoutNeighbours_Death() throws Exception {
        RuleCell cell = aLiveRuleCell().withoutNeighbours().build();
        String outcome = underpopulationRule.apply(cell);

        assertThat(outcome).isEqualTo(DEATH);
    }

    @Test
    public void apply_LiveCellWithExactlyOneNeighbour_Death() throws Exception {
        RuleCell ruleCell = aLiveRuleCell().withAmountOfNeighbours(1).build();
        String outcome = underpopulationRule.apply(ruleCell);

        assertThat(outcome).isEqualTo(DEATH);
    }

    @Test
    public void apply_LiveCellWithExactlyTwoNeighbours_Nothing() throws Exception {
        RuleCell ruleCell = aLiveRuleCell().withAmountOfNeighbours(2).build();
        String outcome = underpopulationRule.apply(ruleCell);

        assertThat(outcome).isEqualTo(NOTHING);
    }

    @Test
    public void apply_DeadCellWithoutNeighbours_Nothing() throws Exception {
        RuleCell ruleCell = aDeadRuleCell().withoutNeighbours().build();
        String outcome = underpopulationRule.apply(ruleCell);

        assertThat(outcome).isEqualTo(NOTHING);
    }

    @Test
    public void apply_DeadCellWithExactlyOneNeighbour_Nothing() throws Exception {
        RuleCell ruleCell = aDeadRuleCell().withAmountOfNeighbours(1).build();
        String outcome = underpopulationRule.apply(ruleCell);

        assertThat(outcome).isEqualTo(NOTHING);
    }

    @Test
    public void apply_DeadCellWithExactlyTwoNeighbours_Nothing() throws Exception {
        RuleCell ruleCell = aDeadRuleCell().withAmountOfNeighbours(2).build();
        String outcome = underpopulationRule.apply(ruleCell);

        assertThat(outcome).isEqualTo(NOTHING);
    }
}
