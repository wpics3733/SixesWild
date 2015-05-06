package SixesWild.Controllers.GameScreen;

import SixesWild.Controllers.ButtonController;
import SixesWild.Views.Application;
import SixesWild.Views.Components.StyledButton;
import SixesWild.Views.Components.SpecialMoveNavigationBar;

import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/5/15.
 */
public class SpecialMoveButtonController extends ButtonController {
    SpecialMoveNavigationBar specialMoveNavigationBar;
    Application app;

    public SpecialMoveButtonController(StyledButton button, SpecialMoveNavigationBar specialMoveNavigationBar,Application app) {
        super(button);
        this.specialMoveNavigationBar = specialMoveNavigationBar;
        this.app = app;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        specialMoveNavigationBar.setAllMoveButtonNormal();
        button.actived();
    }
}
