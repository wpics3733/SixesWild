package SixesWild.Views.Screens.BadgeScreenPackage;

import SixesWild.Models.Badge;
import SixesWild.Views.Application;
import SixesWild.Views.Components.DetailPanel;
import SixesWild.Views.Screens.FlipPageScreen;

import java.util.ArrayList;

/**
 *
 */
public class BadgesScreen extends FlipPageScreen {

    ArrayList<Badge> badges;

    BadgeFlipPagePanel badgeFlipPagePanel;

    public BadgesScreen(String title, Application app, String navTitle) {

        super(title, app, navTitle);
        setUpBadgeList();
    }

    void setUpBadgeList() {

//        Read badge files here, and add badge into ArrayList<Badge> badges


        badges = null;

        getBadgeDetailPanel().setPreferredSize(DetailPanel.DETAIL_PANEL_SIZE);
        getBadgeDetailPanel().setMinimumSize(DetailPanel.DETAIL_PANEL_SIZE);
        getBadgeDetailPanel().setMaximumSize(DetailPanel.DETAIL_PANEL_SIZE);

        getBadgeDetailPanel().setBounds(DETAIL_PANEL_BOUNDS);
        add(getBadgeDetailPanel());

        getBadgeFlipPagePanel().setPreferredSize(FLIP_PAGE_PANEL_SIZE);
        getBadgeFlipPagePanel().setMinimumSize(FLIP_PAGE_PANEL_SIZE);
        getBadgeFlipPagePanel().setMaximumSize(FLIP_PAGE_PANEL_SIZE);

        getBadgeFlipPagePanel().setBounds(FLIP_PAGE_PANEL_BOUNDS);
        add(getBadgeFlipPagePanel());

    }

    public BadgeDetailPanel getBadgeDetailPanel() {
        if (getDetailPanel() == null) {
            setDetailPanel(new BadgeDetailPanel());
        }

        return (BadgeDetailPanel) getDetailPanel();
    }

    public BadgeFlipPagePanel getBadgeFlipPagePanel() {
        if (badgeFlipPagePanel == null) {
            badgeFlipPagePanel = new BadgeFlipPagePanel(this, badges);
        }

        return badgeFlipPagePanel;
    }
}