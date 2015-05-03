package SixesWild.Controllers;

import SixesWild.Contracts.TipContract;
import SixesWild.Views.Application;
import SixesWild.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 *
 */
public class CloseWindowButtonController extends ButtonController{

    public CloseWindowButtonController(StyledButton button) {
        super(button);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.exit(Application.EXECUTION_FINE);
    }
}