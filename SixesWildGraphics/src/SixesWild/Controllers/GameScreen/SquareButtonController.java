package SixesWild.Controllers.GameScreen;

import SixesWild.Controllers.ButtonController;
import SixesWild.Views.Components.StyledButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/4/15.
 */
public class SquareButtonController extends ButtonController {
    public SquareButtonController(StyledButton button) {
        super(button);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        button.actived();
    }
}
