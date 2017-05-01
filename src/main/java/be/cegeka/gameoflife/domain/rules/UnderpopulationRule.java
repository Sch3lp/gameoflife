package be.cegeka.gameoflife.domain.rules;

public class UnderpopulationRule {

    public static final String DEATH = "Death";
    public static final String NOTHING = "Nothing";

    public String apply(RuleCell cell) {
        if (cell.isAlive() && cell.amountOfLiveNeighbours() < 2) return DEATH;
        return NOTHING;
    }
}
