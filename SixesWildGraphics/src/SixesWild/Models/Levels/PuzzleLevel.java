package SixesWild.Models.Levels;

import SixesWild.Models.Grid;
import SixesWild.Models.Score;
import SixesWild.Models.SpecialMoveLeft;
import SixesWild.Models.Value;
import SixesWild.Moves.ISpecialMove;

import java.util.Stack;

/**
 *
 */
public class PuzzleLevel extends Level {

    Value swapNeighborMoveLeft;

    public PuzzleLevel(boolean unlockState) {
        super(unlockState);
    }

    public PuzzleLevel(boolean unlockState, Value id, Score score, Grid grid, SpecialMoveLeft specialMoveLeft, Probabilities probabilities, Value swapNeighborMoveLeft) {
        super(unlockState, id, score, grid, specialMoveLeft, probabilities);
        this.swapNeighborMoveLeft = swapNeighborMoveLeft;
    }

    public boolean hasWon() {
        return swapNeighborMoveLeft.getValue() == 0;
    }

    public Value getSwapNeighborMoveLeft() {
        return swapNeighborMoveLeft;
    }

    public void setSwapNeighborMoveLeft(Value swapNeighborMoveLeft) {
        this.swapNeighborMoveLeft = swapNeighborMoveLeft;
    }

    @Override
    public void finishMakingMove() {
        super.finishMakingMove();
        swapNeighborMoveLeft.decrease(1);
    }
}