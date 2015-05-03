package SixesWild.Views.Screens;

import SixesWild.Views.Application;
import SixesWild.Views.Components.NavigationBar;

import java.awt.*;

/**
 *
 */
public class NavigableScreen extends Screen {

    //    Navigation bar height
    final int NAV_BAR_HEIGHT = 58;
    //    Navigation bar bounds
    final Rectangle NAV_BAR_BOUNDS = new Rectangle(0, 30, Application.WINDOW_WIDTH, NAV_BAR_HEIGHT);

    NavigationBar navigationBar;

    public NavigableScreen(String title, Application app) {
        super(title, app);
        navigationBar = new NavigationBar(this.app);
        navigationBar.setPreferredSize(new Dimension((int) getPreferredSize().getWidth(), NAV_BAR_HEIGHT));
        navigationBar.setBounds(NAV_BAR_BOUNDS);

        this.add(navigationBar);
    }
}