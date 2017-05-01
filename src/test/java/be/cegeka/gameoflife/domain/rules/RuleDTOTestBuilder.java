package be.cegeka.gameoflife.domain.rules;

public class RuleDTOTestBuilder {

    private boolean isDead;
    private int amountOfNeighbours;

    private RuleDTOTestBuilder() {}

    public static RuleDTOTestBuilder aRuleDTO() {
        return new RuleDTOTestBuilder();
    }

    public RuleDTOTestBuilder withDead(boolean dead) {
        isDead = dead;
        return this;
    }

    public RuleDTOTestBuilder withAmountOfNeighbours(int amountOfNeighbours) {
        this.amountOfNeighbours = amountOfNeighbours;
        return this;
    }

    public RuleDTO build() {
        return new RuleDTO(isDead, amountOfNeighbours);
    }

}