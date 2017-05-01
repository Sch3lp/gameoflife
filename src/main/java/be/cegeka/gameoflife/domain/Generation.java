package be.cegeka.gameoflife.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generation {
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
}
