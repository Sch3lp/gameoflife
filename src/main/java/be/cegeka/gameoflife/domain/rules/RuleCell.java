package be.cegeka.gameoflife.domain.rules;

public class RuleCell {

    private final boolean alive;
    private final int amountOfLiveNeighbours;

    RuleCell(boolean alive, int amountOfLiveNeighbours) {
        this.alive = alive;
        this.amountOfLiveNeighbours = amountOfLiveNeighbours;
    }

    boolean isAlive() {
        return alive;
    }

    boolean isDead() {
        return !isAlive();
    }

    int amountOfLiveNeighbours() {
        return amountOfLiveNeighbours;
    }
}
