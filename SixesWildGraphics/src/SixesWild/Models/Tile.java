package SixesWild.Models;

/**
 *
 */
public class Tile {


    Value number;
    BonusMultiplier mutiplier;

    public Tile(Value number, BonusMultiplier mutiplier) {
        this.number = number;
        this.mutiplier = mutiplier;
    }

    public Value getNumber() {
        return number;
    }

    public void setNumber(Value number) {
        this.number = number;
    }

    public BonusMultiplier getMutiplier() {
        return mutiplier;
    }

    public void setMutiplier(BonusMultiplier mutiplier) {
        this.mutiplier = mutiplier;
    }
}