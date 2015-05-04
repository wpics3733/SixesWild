package SixesWild.Views.Screens.BadgeScreenPackage;

import SixesWild.Models.Badge;
import SixesWild.Views.Components.DetailPanel;
import SixesWild.Views.Components.ListPanel;

/**
 *
 */
public class BadgeListPanel extends ListPanel {

    Badge[] badges;

    BadgeDetailPanel badgeDetailPanel;

    public BadgeListPanel(DetailPanel detailPanel, Badge[] badges, BadgeDetailPanel badgeDetailPanel) {
        super(detailPanel);
        this.badges = badges;
        this.badgeDetailPanel = badgeDetailPanel;
    }

    @Override
    public void setUpViews() {

    }
}