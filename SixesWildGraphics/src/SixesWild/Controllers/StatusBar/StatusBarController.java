package SixesWild.Controllers.StatusBar;

import SixesWild.Views.Application;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/2/15.
 */
public class StatusBarController extends MouseAdapter {
    Application app;
    Point origin;

    public StatusBarController(Application app) {
        this.app = app;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        origin = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        origin = null;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        moveWindow(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        moveWindow(e);
    }

    void moveWindow(MouseEvent e) {
        if (origin != null) {
            int windowX = app.getX();
            int windowY = app.getY();

            int windowNewX = windowX + (int)(e.getX() - origin.getX());
            int windowNewY = windowY + (int)(e.getY() - origin.getY());

            app.setLocation(windowNewX, windowNewY);
        }
    }

}
