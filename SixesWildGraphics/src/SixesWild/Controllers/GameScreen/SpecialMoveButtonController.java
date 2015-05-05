package SixesWild.Controllers.GameScreen;

import SixesWild.Controllers.ButtonController;
import SixesWild.Views.Components.StyledButton;
import SixesWild.Views.Components.SpecialMoveNavigationBar;

import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/5/15.
 */
public class SpecialMoveButtonController extends ButtonController {
    SpecialMoveNavigationBar specialMoveNavigationBar;

    public SpecialMoveButtonController(StyledButton button, SpecialMoveNavigationBar specialMoveNavigationBar) {
        super(button);
        this.specialMoveNavigationBar = specialMoveNavigationBar;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        specialMoveNavigationBar.setAllMoveButtonNormal();
        button.actived();
    }
}
