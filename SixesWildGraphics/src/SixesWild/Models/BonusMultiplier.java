package SixesWild.Models;

/**
 *
 */
public class BonusMultiplier {

    Value multiplier;

    public BonusMultiplier(Value multiplier) {
        this.multiplier = multiplier;
    }

    public Value getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Value multiplier) {
        this.multiplier = multiplier;
    }
}