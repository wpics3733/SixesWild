package SixesWild.Controllers.GameScreen;

import SixesWild.Moves.SpecialMoves.ClearTileSpecialMove;
import SixesWild.Views.Application;
import SixesWild.Views.Components.StyledButton;
import SixesWild.Views.Components.SpecialMoveNavigationBar;

import java.awt.event.MouseEvent;

/**
 *
 */
public class ClearTileSpecialMoveController extends SpecialMoveButtonController{

    public ClearTileSpecialMoveController(StyledButton button, SpecialMoveNavigationBar specialMoveNavigationBar, Application app) {
        super(button, specialMoveNavigationBar, app);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mousePressed(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        app.getGameScreen().getGridView().setSpecialMove(new ClearTileSpecialMove(app.getGameScreen().getGridView().getGrid()));
        super.mousePressed(e);
    }
}