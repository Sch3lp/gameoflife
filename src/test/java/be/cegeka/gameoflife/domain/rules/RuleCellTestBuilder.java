package be.cegeka.gameoflife.domain.rules;

import be.cegeka.gameoflife.domain.Position;

public class RuleCellTestBuilder {

    private boolean isAlive;
    private int amountOfNeighbours;
    private Position position;

    private RuleCellTestBuilder(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public static RuleCellTestBuilder aLiveRuleCell() {
        return new RuleCellTestBuilder(true);
    }

    public static RuleCellTestBuilder aDeadRuleCell() {
        return new RuleCellTestBuilder(false);
    }


    public RuleCellTestBuilder withAmountOfNeighbours(int amountOfNeighbours) {
        this.amountOfNeighbours = amountOfNeighbours;
        return this;
    }

    public RuleCellTestBuilder withoutNeighbours() {
        this.amountOfNeighbours = 0;
        return this;
    }

    public RuleCellTestBuilder withPosition(Position position) {
        this.position = position;
        return this;
    }

    public RuleCell build() {
        return new RuleCell(isAlive, amountOfNeighbours, position);
    }

}