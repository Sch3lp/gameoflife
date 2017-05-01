package be.cegeka.gameoflife.domain.rules;

import be.cegeka.gameoflife.domain.Cell;

import java.util.List;

public class RuleCellFactory {
    public RuleCell createRuleCell(Cell cell, List<Cell> liveNeighbours) {
        return new RuleCell(cell.isAlive(), liveNeighbours.size());
    }
}
