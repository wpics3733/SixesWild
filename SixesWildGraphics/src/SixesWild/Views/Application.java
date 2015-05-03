package SixesWild.Views;

import SixesWild.Views.Screens.*;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class Application extends JFrame {

    //    Application name
    public static final String APP_NAME = "SixesWild";

    //    window width
    public static final int WINDOW_WIDTH = 1024;
    //    windows height
    public static final int WINDOW_HEIGHT = 768;

    //    Root path of application
    public static final String ROOT_PATH = "user.dir";

    //    Font locations of regular, italic and bold.
    public static final String REGULAR_FONT_LOCATION = "/assets/AvenirNextRegular.ttf";
    public static final String ITALIC_FONT_LOCATION = "/assets/AvenirNextIt.ttf";
    public static final String BOLD_FONT_LOCATION = "/assets/AvenirNextBold.ttf";

    //    Application running state. 0 when execution when fine.
    public static final int EXECUTION_FINE = 0;

//    Title of application
    final String APPLICATION_TITLE = "SixesWild";

//    Title of individual screens
    final String ABOUT_SCREEN_TITLE = APPLICATION_TITLE + " - About";


    /**
     *
     */
    JPanel titlePanel;
    /**
     *
     */
    MenuScreen menuScreen;
    /**
     *
     */
    GameScreen gameScreen;
    /**
     *
     */
    BadgesScreen badgesScreen;
    /**
     *
     */
    LevelsScreen levelsScreen;
    /**
     *
     */
    AboutScreen aboutScreen;
    /**
     *
     */
    AnimationManager animationManager;

    /**
     *
     */
    public Application() {
        super(Application.APP_NAME);
        this.setSize(Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT));
        this.setContentPane(layeredPane);

        this.setLayout(null);

        AboutScreen aboutScreen = new AboutScreen(ABOUT_SCREEN_TITLE, this);

        aboutScreen.setBounds(0, 0, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);

        this.add(aboutScreen);
    }
}