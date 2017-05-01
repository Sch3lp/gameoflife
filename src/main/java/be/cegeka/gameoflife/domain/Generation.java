package be.cegeka.gameoflife.domain;

import be.cegeka.gameoflife.domain.rules.RuleCell;
import be.cegeka.gameoflife.domain.rules.RuleCellFactory;
import be.cegeka.gameoflife.domain.rules.RuleCommand;
import be.cegeka.gameoflife.domain.rules.UnderpopulationRule;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static be.cegeka.gameoflife.domain.Position.pos;
import static be.cegeka.gameoflife.domain.rules.UnderpopulationRule.DEATH;

public class Generation {
    private final UnderpopulationRule underpopulationRule = new UnderpopulationRule();
    private final RuleCellFactory ruleCellFactory = new RuleCellFactory();

    private List<List<Cell>> cells;

    public Generation(List<List<Cell>> cells) {
        this.cells = cells;
    }

    @SafeVarargs
    public static Generation of(List<Cell>... cells) {
        return new Generation(Arrays.asList(cells));
    }

    public List<List<Cell>> as2DList() {
        return cells;
    }

    public List<Cell> getLiveNeighbours(Position pos) {
        if (cellAt(pos) == null) return Collections.emptyList();
        return findLiveNeighbours(pos);
    }

    private List<Cell> findLiveNeighbours(Position pos) {
        return findExistingNeighbours(pos)
                .filter(Cell::isAlive)
                .collect(Collectors.toList());
    }

    private Stream<Cell> findExistingNeighbours(Position pos) {
        return Stream.of(
                cellAt(pos.top().left()),
                cellAt(pos.top()),
                cellAt(pos.top().right()),
                cellAt(pos.left()),
                cellAt(pos.right()),
                cellAt(pos.bottom().left()),
                cellAt(pos.bottom()),
                cellAt(pos.bottom().right())
        )
        .filter(Objects::nonNull);
    }

    Cell cellAt(Position pos) {
        Cell cell;
        try {
            cell = this.cells.get(pos.x).get(pos.y);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        return cell;
    }

    public Generation tick() {
        getAllCellPositions().stream().map(pos -> ruleCellFactory.createRuleCell(cellAt(pos), getLiveNeighbours(pos), pos))
        .collect(Collectors.toList()).stream()
        .map(this::underpopulationRule)
        .forEach(command -> command.execute(cellAt(command.position())));
        return this;
    }

    List<Position> getAllCellPositions() {
        List<Position> positions = new ArrayList<>();
        for (int x = 0; x < cells.size(); x++) {
            for (int y = 0; y < cells.get(x).size(); y++) {
                positions.add(pos(x,y));
            }
        }
        return positions;
    }

    private RuleCommand underpopulationRule(RuleCell ruleCell) {
        String outcome = underpopulationRule.apply(ruleCell);
        if (DEATH.equals(outcome)) {
            return new RuleCommand(){
                @Override
                public void execute(Cell cell) {
                    cell.kill();
                }

                @Override
                public Position position() {
                    return ruleCell.position();
                }
            };
        } else {
            return new RuleCommand(){
                @Override
                public void execute(Cell cell) {
                }

                @Override
                public Position position() {
                    return ruleCell.position();
                }
            };
        }
    }
}
