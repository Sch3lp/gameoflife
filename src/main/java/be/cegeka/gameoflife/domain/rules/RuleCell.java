package be.cegeka.gameoflife.domain.rules;

public class RuleCell {

    private final boolean alive;
    private final long amountOfLiveNeighbours;

    RuleCell(boolean alive, long amountOfLiveNeighbours) {
        this.alive = alive;
        this.amountOfLiveNeighbours = amountOfLiveNeighbours;
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
}
