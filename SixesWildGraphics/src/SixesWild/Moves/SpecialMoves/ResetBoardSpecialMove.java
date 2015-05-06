package SixesWild.Moves.SpecialMoves;

import SixesWild.Models.Grid;
import SixesWild.Moves.ISpecialMove;
import SixesWild.Views.Application;

public class ResetBoardSpecialMove implements ISpecialMove {


    Grid grid;

    public ResetBoardSpecialMove(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public boolean doMove(Application app) {
        return false;
    }
}