package SixesWild.Models.Levels;

import SixesWild.Models.*;

import java.util.ArrayList;

/**
 *
 */
public class EliminationLevel extends Level {

    ArrayList<Square> markedSquares;

    public EliminationLevel(boolean unlockState) {
        super(unlockState);
        this.markedSquares = new ArrayList<Square>();
    }

    public EliminationLevel(boolean unlockState, Value id, Score score, Grid grid, SpecialMoveLeft specialMoveLeft, Probabilities probabilities) {
        super(unlockState, id, score, grid, specialMoveLeft, probabilities);
        this.markedSquares = new ArrayList<Square>();
    }

    public boolean hasWon() {
        return false;
    }

    public Value getNotMakred() {
        return new Value(Grid.MAX_TILES - markedSquares.size());
    }

}