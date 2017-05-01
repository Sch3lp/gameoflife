package be.cegeka.gameoflife;

public class RuleDTO {

    private final boolean dead;
    private final int amountOfLiveNeighbours;

    RuleDTO(boolean dead, int amountOfLiveNeighbours) {
        this.dead = dead;
        this.amountOfLiveNeighbours = amountOfLiveNeighbours;
    }

    public boolean isDead() {
        return dead;
    }

    public int amountOfliveNeighbours() {
        return amountOfLiveNeighbours;
    }
}
