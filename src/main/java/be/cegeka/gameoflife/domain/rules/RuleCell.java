package be.cegeka.gameoflife.domain.rules;

import be.cegeka.gameoflife.domain.Position;

public class RuleCell {

    private final boolean alive;
    private final long amountOfLiveNeighbours;
    private Position position;

    RuleCell(boolean alive, long amountOfLiveNeighbours, Position position) {
        this.alive = alive;
        this.amountOfLiveNeighbours = amountOfLiveNeighbours;
        this.position = position;
    }

    boolean isAlive() {
        return alive;
    }

    boolean isDead() {
        return !isAlive();
    }

    long amountOfLiveNeighbours() {
        return amountOfLiveNeighbours;
    }

    public Position position() {
        return position;
    }
}
