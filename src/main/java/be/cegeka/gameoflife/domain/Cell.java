package be.cegeka.gameoflife.domain;

import java.util.Objects;

public class Cell {
    private boolean alive;

    public static Cell live() {
        return new Cell(true);
    }

    public static Cell dead() {
        return new Cell(false);
    }

    private Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isDead() {
        return !isAlive();
    }

    public void kill() {
        alive = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return alive == cell.alive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(alive);
    }


    @Override
    public String toString() {
        return alive ? "live" : "dead";
    }
}
