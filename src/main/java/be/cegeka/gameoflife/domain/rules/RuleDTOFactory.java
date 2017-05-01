package be.cegeka.gameoflife.domain.rules;

import be.cegeka.gameoflife.domain.Cell;

import java.util.List;

public class RuleDTOFactory {
    public RuleDTO createRuleDTO(Cell cell, List<Cell> liveNeighbours) {
        return new RuleDTO(cell.isDead(), liveNeighbours.size());
    }
}
