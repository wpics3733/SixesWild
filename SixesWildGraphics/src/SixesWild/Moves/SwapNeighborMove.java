package SixesWild.Moves;

import SixesWild.Models.Grid;
import SixesWild.Models.Square;
import SixesWild.Models.Value;
import SixesWild.Utilities;
import SixesWild.Views.Application;
import SixesWild.Views.Components.ScoreSpecialMoveNavigationBar;

import java.util.ArrayList;

/**
 *
 */
public class SwapNeighborMove implements IMove {

    final int BASE_SCORE = 10;

    Grid grid;

    public SwapNeighborMove(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean isValid() {
        boolean validation = true;

        Value count = new Value(0);

        ArrayList<Square> activeSquares = grid.getActiveSquare();
        int numberActived = activeSquares.size();
        if (numberActived > 0) {
            for (int i = 0; i < numberActived - 1; i++) {
                Square currentSquare = activeSquares.get(i);
                Square nextSquare = activeSquares.get(i + 1);

                if (!currentSquare.isAdjacent(nextSquare)) {
                    validation = false;
                } else {
                    count.increase(currentSquare.getTile().getNumber().getValue());
                }
            }

            count.increase(activeSquares.get(numberActived - 1).getTile().getNumber().getValue());
            if (count.getValue() != Utilities.SIX) {
                validation = false;
            }
        } else {
            validation = false;
        }

        return validation;
    }

    @Override
    public boolean doMove(Application app) {
        if (isValid()) {
            Value count = new Value(0);
            ArrayList<Square> activeSquares = grid.getActiveSquare();
            int numberActived = activeSquares.size();

            count.increase(BASE_SCORE * numberActived);

            for (int i = 0; i < numberActived; i++) {
                count.multiply(activeSquares.get(i).getTile().getMutiplier().getMultiplier().getValue());
                grid.getActiveSquare().get(i).setTile(null);
            }

            app.getGameScreen().updateScore(count);
            return true;

        } else {
            return false;
        }
    }
}