package SixesWild.Controllers.ViewBadgeScreen;

import SixesWild.Controllers.FlipScreen.LockableButtonController;
import SixesWild.Models.Badge;
import SixesWild.Views.Components.LockableButton;
import SixesWild.Views.Components.LockableButtonView;
import SixesWild.Views.Screens.BadgeScreenPackage.BadgeDetailPanel;
import SixesWild.Views.Screens.BadgeScreenPackage.BadgeListPanel;

/**
 * Created by harryliu on 5/4/15.
 */
public class BadgeButtonController extends LockableButtonController {
    Badge badge;
    BadgeDetailPanel badgeDetailPanel;


    public BadgeButtonController(
            LockableButton button,
            BadgeListPanel badgeListPanel,
            LockableButtonView lockableButtonView,
            Badge badge,
            BadgeDetailPanel badgeDetailPanel) {

        super(button, badgeListPanel, lockableButtonView);
        this.badge = badge;
        this.badgeDetailPanel = badgeDetailPanel;
    }
}
