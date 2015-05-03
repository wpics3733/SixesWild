package SixesWild.Controllers;

import SixesWild.Views.Components.StyledButton;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 */
public class ButtonController extends MouseAdapter {

    //      Target button view
    StyledButton button;

    public ButtonController(StyledButton button) {
        this.button = button;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        button.hovered();
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        button.normal();
        button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}