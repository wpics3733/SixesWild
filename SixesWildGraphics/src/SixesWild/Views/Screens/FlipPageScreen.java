package SixesWild.Views.Screens;

import SixesWild.Views.Application;
import SixesWild.Views.FlipPagePanel;

/**
 *
 */
public class FlipPageScreen extends NavigableScreen {

    /**
     *
     */
    FlipPagePanel flipPagePanel;

    /**
     *
     */
    public FlipPageScreen(String title, Application app, String navTitle) {

        super(title, app);
        navigationBar.setNavTitle(navTitle);
    }

}