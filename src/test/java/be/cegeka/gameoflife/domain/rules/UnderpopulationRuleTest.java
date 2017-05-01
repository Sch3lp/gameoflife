package be.cegeka.gameoflife.domain.rules;

import be.cegeka.gameoflife.domain.Cell;
import org.junit.Test;

import java.util.List;

import static be.cegeka.gameoflife.domain.Cell.dead;
import static be.cegeka.gameoflife.domain.Cell.live;
import static be.cegeka.gameoflife.domain.rules.RuleDTOTestBuilder.aRuleDTO;
import static be.cegeka.gameoflife.domain.rules.UnderpopulationRule.DEATH;
import static be.cegeka.gameoflife.domain.rules.UnderpopulationRule.NOTHING;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

public class UnderpopulationRuleTest {

    @Test
    public void apply_LiveCellWithoutNeighbours_Death() throws Exception {
        RuleDTO ruleDTO = aRuleDTO().withDead(false).withAmountOfNeighbours(0).build();
        String outcome = new UnderpopulationRule().apply(ruleDTO);

        assertThat(outcome).isEqualTo(DEATH);
    }

    @Test
    public void apply_LiveCellWithExactlyOneNeighbour_Death() throws Exception {
        Cell liveCell = live();
        List<Cell> liveNeighbours = asList(live());

        RuleDTO ruleDTO = createRuleDTO(liveCell, liveNeighbours);
        String outcome = new UnderpopulationRule().apply(ruleDTO);

        assertThat(outcome).isEqualTo(DEATH);
    }

    @Test
    public void apply_LiveCellWithExactlyTwoNeighbours_Nothing() throws Exception {
        Cell liveCell = live();
        List<Cell> liveNeighbours = asList(live(), live());

        RuleDTO ruleDTO = createRuleDTO(liveCell, liveNeighbours);
        String outcome = new UnderpopulationRule().apply(ruleDTO);

        assertThat(outcome).isEqualTo(NOTHING);
    }

    @Test
    public void apply_DeadCellWithoutNeighbours_Nothing() throws Exception {
        Cell deadCell = dead();
        List<Cell> liveNeighbours = emptyList();

        RuleDTO ruleDTO = createRuleDTO(deadCell, liveNeighbours);
        String outcome = new UnderpopulationRule().apply(ruleDTO);

        assertThat(outcome).isEqualTo(NOTHING);
    }

    @Test
    public void apply_DeadCellWithExactlyOneNeighbour_Nothing() throws Exception {
        Cell deadCell = dead();
        List<Cell> liveNeighbours = asList(live());

        RuleDTO ruleDTO = createRuleDTO(deadCell, liveNeighbours);
        String outcome = new UnderpopulationRule().apply(ruleDTO);

        assertThat(outcome).isEqualTo(NOTHING);
    }

    @Test
    public void apply_DeadCellWithExactlyTwoNeighbours_Nothing() throws Exception {
        Cell deadCell = dead();
        List<Cell> liveNeighbours = asList(live(), live());

        RuleDTO ruleDTO = createRuleDTO(deadCell, liveNeighbours);
        String outcome = new UnderpopulationRule().apply(ruleDTO);

        assertThat(outcome).isEqualTo(NOTHING);
    }

    private RuleDTO createRuleDTO(Cell liveCell, List<Cell> liveNeighbours) {
        return new RuleDTOFactory().createRuleDTO(liveCell, liveNeighbours);
    }
}
