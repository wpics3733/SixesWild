package SixesWild.Views.Screens;

import SixesWild.Controllers.StatusBar.StatusBarController;
import SixesWild.Views.Application;
import SixesWild.Views.Components.StatusBar;
import SixesWild.Views.TransitableView;

import java.awt.*;

/**
 * Created by harryliu on 5/2/15.
 */
public class Screen extends TransitableView {

    //    Status bar height
    public static final int STATUS_BAR_HEIGHT = 30;
    //    Status bar padding top
    final int PADDING_TOP = 0;
    //    Status bar padding left
    final int PADDING_LEFT = 0;
//    Screen background color
    public static final Color SCREEN_BACK_COLOR = new Color(249, 246, 242);

    //    Title of the screen
    String title;
    protected Application app;

    public Screen(String title, Application app) {
        this.title = title;
        this.app = app;

        setPreferredSize(new Dimension(Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT));
        setMinimumSize(new Dimension(Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT));
        setMaximumSize(new Dimension(Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT));

        setBackground(SCREEN_BACK_COLOR);

        initialize();
    }

    void initialize() {

        setLayout(null);

        StatusBar statusBar = new StatusBar(title);
        statusBar.setPreferredSize(new Dimension(Application.WINDOW_WIDTH, STATUS_BAR_HEIGHT));
        statusBar.setMinimumSize(new Dimension(Application.WINDOW_WIDTH, STATUS_BAR_HEIGHT));
        statusBar.setMaximumSize(new Dimension(Application.WINDOW_WIDTH, STATUS_BAR_HEIGHT));

        statusBar.setBounds(PADDING_TOP, PADDING_LEFT, (int) getPreferredSize().getWidth(), STATUS_BAR_HEIGHT);

        StatusBarController statusBarController = new StatusBarController(app);
        statusBar.addMouseListener(statusBarController);
        statusBar.addMouseMotionListener(statusBarController);

        this.add(statusBar);
    }

    public String getTitle() {
        return title;
    }

    public Application getApp() {
        return app;
    }
}
