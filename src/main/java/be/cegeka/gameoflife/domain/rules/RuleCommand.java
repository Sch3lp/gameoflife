package be.cegeka.gameoflife.domain.rules;

import be.cegeka.gameoflife.domain.Cell;
import be.cegeka.gameoflife.domain.Position;

public interface RuleCommand {
    Position position();
    void execute(Cell cell);
}
