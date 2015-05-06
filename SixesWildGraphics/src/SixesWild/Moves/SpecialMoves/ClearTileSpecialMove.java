package SixesWild.Moves.SpecialMoves;

import SixesWild.Models.Grid;
import SixesWild.Models.Square;
import SixesWild.Moves.ISpecialMove;
import SixesWild.Views.Application;

/**
 *
 */
public class ClearTileSpecialMove implements ISpecialMove {

    Grid grid;

    public ClearTileSpecialMove(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean isValid() {
        boolean validation = false;
        if(grid.getActiveSquare().size()>0 && grid.getActiveSquare().get(0).getTile()!=null){
            validation = true;
        }

        return validation;
    }

    @Override
    public boolean doMove(Application app) {
        if(isValid()) {
            grid.getActiveSquare().get(0).setTile(null);
            app.getGameScreen().modelChanged();
            return true;
        } else {
            return false;
        }
    }
}