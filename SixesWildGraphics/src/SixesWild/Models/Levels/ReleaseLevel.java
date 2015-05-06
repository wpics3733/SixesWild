package SixesWild.Models.Levels;

import SixesWild.Models.*;
import SixesWild.Moves.ISpecialMove;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 */
public class ReleaseLevel extends Level {

    ArrayList<Square> sixReceivers;

    ArrayList<Square> notEmptyReceivers;

    public ReleaseLevel(boolean unlockState) {
        super(unlockState);
    }

    public ReleaseLevel(boolean unlockState, Value id, Score score, Grid grid, SpecialMoveLeft specialMoveLeft, Probabilities probabilities) {
        super(unlockState, id, score, grid, specialMoveLeft, probabilities);
        this.notEmptyReceivers = new ArrayList<Square>();
    }

    public boolean hasWon() {
        return false;
    }

    public Value getNumNotEmpty() {
        return new Value(notEmptyReceivers.size());
    }
}