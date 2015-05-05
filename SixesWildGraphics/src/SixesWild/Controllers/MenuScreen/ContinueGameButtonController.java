package SixesWild.Controllers.MenuScreen;

import SixesWild.Controllers.ButtonController;
import SixesWild.Views.Application;
import SixesWild.Views.Components.StyledButton;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 *
 */
public class ContinueGameButtonController extends ButtonController {

    Application app;

    public ContinueGameButtonController(StyledButton button, Application app) {
        super(button);
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        app.switchTo(app.getGameScreen());
    }
}