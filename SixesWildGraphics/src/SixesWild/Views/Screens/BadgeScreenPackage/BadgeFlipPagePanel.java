package SixesWild.Views.Screens.BadgeScreenPackage;

import SixesWild.Models.Badge;
import SixesWild.Views.Components.FlipPagePanel;
import SixesWild.Views.Components.ListPanel;
import SixesWild.Views.Screens.FlipPageScreen;

import java.util.ArrayList;

/**
 * Created by harryliu on 5/4/15.
 */
public class BadgeFlipPagePanel extends FlipPagePanel {
    ArrayList<Badge> badges;

    public BadgeFlipPagePanel(FlipPageScreen flipPageScreen, ArrayList<Badge> badges) {
        super(flipPageScreen);
        this.badges = badges;

        getBadgelListPanel().setPreferredSize(ListPanel.LIST_PANEL_SIZE);
        getBadgelListPanel().setMaximumSize(ListPanel.LIST_PANEL_SIZE);
        getBadgelListPanel().setMinimumSize(ListPanel.LIST_PANEL_SIZE);

        getBadgelListPanel().setBounds(ListPanel.LIST_PANEL_BOUNDS);
        add(getBadgelListPanel());

        initialize();
    }

    public BadgeListPanel getBadgelListPanel() {
        if(getListPanel() == null) {
            setListPanel(new BadgeListPanel(badges, (BadgeDetailPanel) getFlipPageScreen().getDetailPanel()));
        }

        return (BadgeListPanel)getListPanel();
    }
}
