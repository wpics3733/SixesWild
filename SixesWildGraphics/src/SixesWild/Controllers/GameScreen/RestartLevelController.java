package SixesWild.Controllers.GameScreen;

import SixesWild.Controllers.ButtonController;
import SixesWild.Views.Application;
import SixesWild.Views.Components.StyledButton;
import SixesWild.Views.Screens.GameScreenPackage.GameScreen;

import java.awt.event.MouseEvent;

/**
 *
 */
public class RestartLevelController extends ButtonController{
    GameScreen gameScreen;

    public RestartLevelController(StyledButton button, GameScreen gameScreen) {
        super(button);
        this.gameScreen = gameScreen;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        gameScreen.restartLevel();
    }
}