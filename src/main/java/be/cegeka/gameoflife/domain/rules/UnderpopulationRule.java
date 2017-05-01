package be.cegeka.gameoflife.domain.rules;

public class UnderpopulationRule {

    public static final String DEATH = "Death";
    public static final String NOTHING = "Nothing";

    public String apply(RuleDTO ruleDTO) {
        if (ruleDTO.isDead()) return NOTHING;
        if (ruleDTO.amountOfliveNeighbours() >= 2) return NOTHING;
        return DEATH;
    }
}
