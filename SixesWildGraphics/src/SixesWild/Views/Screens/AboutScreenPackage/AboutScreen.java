package SixesWild.Views.Screens.AboutScreenPackage;

import SixesWild.Views.Application;
import SixesWild.Views.IModelUpdated;
import SixesWild.Views.Screens.NavigableScreen;

import java.awt.*;

/**
 *
 */
public class AboutScreen extends NavigableScreen{

    //    Developer introduction canvas dimension
    final Dimension DEV_INTRO_CANVAS_SIZE = new Dimension(
            Application.WINDOW_WIDTH,
            Application.WINDOW_HEIGHT - NAV_BAR_HEIGHT - STATUS_BAR_HEIGHT
    );
    //    Developer introduction canvas bounds
    final Rectangle DEV_INTRO_CANVAS_BOUNDS = new Rectangle(
            0,
            NAV_BAR_HEIGHT + STATUS_BAR_HEIGHT,
            Application.WINDOW_WIDTH,
            Application.WINDOW_HEIGHT - NAV_BAR_HEIGHT - STATUS_BAR_HEIGHT
    );

    DeveloperIntroPicture developerIntroPicture;

    public AboutScreen(String title, Application app, String navTitle) {
        super(title, app);

        getNavigationBar().setNavTitle(navTitle);

        developerIntroPicture = new DeveloperIntroPicture();
        developerIntroPicture.setPreferredSize(DEV_INTRO_CANVAS_SIZE);
        developerIntroPicture.setBounds(DEV_INTRO_CANVAS_BOUNDS);

        add(developerIntroPicture);
    }

    @Override
    public void repaint(){
        if(developerIntroPicture != null) {
            developerIntroPicture.repaint();
        }
    }
}