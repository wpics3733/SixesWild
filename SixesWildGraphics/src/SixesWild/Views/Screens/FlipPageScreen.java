package SixesWild.Views.Screens;

import SixesWild.Views.Application;
import SixesWild.Views.Components.DetailPanel;
import SixesWild.Views.Components.FlipPagePanel;
import SixesWild.Views.Components.PageIndicator;

import java.awt.*;

/**
 *
 */
public class FlipPageScreen extends NavigableScreen {

    //    Flip page panel dimension
    public static final Dimension FLIP_PAGE_PANEL_SIZE = new Dimension(
            Application.WINDOW_WIDTH,
            Application.WINDOW_HEIGHT
                    - STATUS_BAR_HEIGHT
                    - NAV_BAR_HEIGHT
                    - (int) DetailPanel.DETAIL_PANEL_SIZE.getHeight()
    );

    //    Flip page panel bounds
    public static final Rectangle FLIP_PAGE_PANEL_BOUNDS = new Rectangle(
            0,
            STATUS_BAR_HEIGHT + NAV_BAR_HEIGHT,
            (int) FLIP_PAGE_PANEL_SIZE.getWidth(),
            (int) FLIP_PAGE_PANEL_SIZE.getHeight()
    );

    //    Detail panel bounds
    public static final Rectangle DETAIL_PANEL_BOUNDS = new Rectangle(
            0,
            Application.WINDOW_HEIGHT
                    - (int) DetailPanel.DETAIL_PANEL_SIZE.getHeight(),
            Application.WINDOW_WIDTH,
            (int) DetailPanel.DETAIL_PANEL_SIZE.getHeight()
    );

    //    Flip page panel
    FlipPagePanel flipPagePanel;

    //    Detail panel
    DetailPanel detailPanel;

    PageIndicator pageIndicator;

    public FlipPageScreen(String title, Application app, String navTitle) {
        super(title, app);
        navigationBar.setNavTitle(navTitle);

        setLayout(null);
        setOpaque(true);

    }

    public FlipPagePanel getFlipPagePanel() {
        return flipPagePanel;
    }

    public void setFlipPagePanel(FlipPagePanel flipPagePanel) {
        this.flipPagePanel = flipPagePanel;
    }

    public DetailPanel getDetailPanel() {
        return detailPanel;
    }

    public void setDetailPanel(DetailPanel detailPanel) {
        this.detailPanel = detailPanel;
    }

    public PageIndicator getPageIndicator() {
        return pageIndicator;
    }

    public void setPageIndicator(PageIndicator pageIndicator) {
        this.pageIndicator = pageIndicator;
    }
}