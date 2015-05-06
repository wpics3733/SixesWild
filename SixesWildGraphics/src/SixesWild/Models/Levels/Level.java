package SixesWild.Models.Levels;

import SixesWild.Models.*;
import SixesWild.Moves.ISpecialMove;

import java.util.Stack;

/**
 *
 */
public abstract class Level extends Unlockable {

    Value id;
    Score score;
    Grid grid;
    SpecialMoveLeft specialMoveLeft;

    Stack moves;
    ISpecialMove specialMove;
    Probabilities probabilities;

    boolean makeingMove;

    public Level(boolean unlockState) {
        super(unlockState);
    }

    public Level(boolean unlockState, Value id, Score score, Grid grid, SpecialMoveLeft specialMoveLeft, Probabilities probabilities) {
        super(unlockState);
        this.id = id;
        this.score = score;
        this.grid = grid;
        this.specialMoveLeft = specialMoveLeft;
        this.probabilities = probabilities;
        this.makeingMove = false;
    }

    public boolean hasSpecialMove() {
        if (specialMove != null) {
            return true;
        }

        return false;
    }

    public abstract boolean hasWon();

    public void beginMakeingMove() {
        makeingMove = true;
    }

    public void finishMakingMove() {
        makeingMove = false;
    }

    public void restart() {
        score.getCurrentScore().multiply(0);
        grid.reset();
    }

    public boolean isMakeingMove() {
        return makeingMove;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public SpecialMoveLeft getSpecialMoveLeft() {
        return specialMoveLeft;
    }

    public void setSpecialMoveLeft(SpecialMoveLeft specialMoveLeft) {
        this.specialMoveLeft = specialMoveLeft;
    }

    public Stack getMoves() {
        return moves;
    }

    public void setMoves(Stack moves) {
        this.moves = moves;
    }

    public ISpecialMove getSpecialMove() {
        return specialMove;
    }

    public void setSpecialMove(ISpecialMove specialMove) {
        this.specialMove = specialMove;
    }

    public void setMakeingMove(boolean makeingMove) {
        this.makeingMove = makeingMove;
    }

    public Value getId() {
        return id;
    }

    public void setId(Value id) {
        this.id = id;
    }
}