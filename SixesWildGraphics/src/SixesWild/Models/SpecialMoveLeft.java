package SixesWild.Models;

/**
 *
 */
public class SpecialMoveLeft {

    Value resetBoardSpecialMoveLetf;
    Value removeTileSpecialMove;
    Value swapTileSpecialMove;

    public SpecialMoveLeft(Value resetBoardSpecialMoveLetf, Value removeTileSpecialMove, Value swapTileSpecialMove) {
        this.resetBoardSpecialMoveLetf = resetBoardSpecialMoveLetf;
        this.removeTileSpecialMove = removeTileSpecialMove;
        this.swapTileSpecialMove = swapTileSpecialMove;
    }

    public Value getResetBoardSpecialMoveLetf() {
        return resetBoardSpecialMoveLetf;
    }

    public void setResetBoardSpecialMoveLetf(Value resetBoardSpecialMoveLetf) {
        this.resetBoardSpecialMoveLetf = resetBoardSpecialMoveLetf;
    }

    public Value getRemoveTileSpecialMove() {
        return removeTileSpecialMove;
    }

    public void setRemoveTileSpecialMove(Value removeTileSpecialMove) {
        this.removeTileSpecialMove = removeTileSpecialMove;
    }

    public Value getSwapTileSpecialMove() {
        return swapTileSpecialMove;
    }

    public void setSwapTileSpecialMove(Value swapTileSpecialMove) {
        this.swapTileSpecialMove = swapTileSpecialMove;
    }
}