package SixesWild.Moves.SpecialMoves;

import SixesWild.Models.Grid;
import SixesWild.Models.Square;
import SixesWild.Moves.ISpecialMove;
import SixesWild.Views.Application;

import java.time.chrono.IsoChronology;

/**
 *
 */
public class SwapSquareSpecialMove implements ISpecialMove {

    Grid grid;

    public SwapSquareSpecialMove(Grid grid) {
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