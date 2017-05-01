package be.cegeka.gameoflife;

import java.util.List;

public class RuleDTOFactory {
    public RuleDTO createRuleDTO(Cell cell, List<Cell> liveNeighbours) {
        return new RuleDTO(cell.isDead(), liveNeighbours.size());
    }
}
