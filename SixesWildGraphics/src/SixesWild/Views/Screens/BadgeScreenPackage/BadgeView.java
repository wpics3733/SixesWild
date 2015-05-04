package SixesWild.Views.Screens.BadgeScreenPackage;

import SixesWild.Contracts.ImageContract;
import SixesWild.Controllers.ViewBadgeScreen.BadgeButtonController;
import SixesWild.Models.Badge;
import SixesWild.Views.Components.ListPanel;
import SixesWild.Views.Components.LockableButton;
import SixesWild.Views.Components.LockableButtonView;
import SixesWild.Views.Screens.Screen;

import java.awt.*;

/**
 * Created by harryliu on 5/4/15.
 */
public class BadgeView extends LockableButtonView {
    //    Badge button size
    final Dimension BADGE_BUTTON_SIZE = new Dimension(72, 72);

    //    Badge button bounds
    final Rectangle BADGE_BUTTON_BOUNDS = new Rectangle(
            0,
            0,
            (int) BADGE_BUTTON_SIZE.getWidth(),
            (int) BADGE_BUTTON_SIZE.getHeight()
    );

    //    Badge button background color
    final Color BADGE_BUTTON_HOVERED_BACK_COLOR = new Color(236, 233, 230);
    final Color BADGE_BUTTON_ACTIVED_BACK_COLOR = new Color(239, 229, 214);
    final Color BADGE_BUTTON_LOCKED_BACK_COLOR = new Color(149, 149, 149);

    //    Default lock state
    final boolean DEFAULT_LOCK_STATE = true;

    //    Badge entity
    Badge badge;
    BadgeDetailPanel badgeDetailPanel;

    public BadgeView(Badge badge, ListPanel listPanel, BadgeDetailPanel badgeDetailPanel) {
        super(listPanel);
        this.badge = badge;
        this.badgeDetailPanel = badgeDetailPanel;

        initialize();
    }

    void initialize() {

        setPreferredSize(ListPanel.VIEW_SIZE);
        setMinimumSize(ListPanel.VIEW_SIZE);
        setMaximumSize(ListPanel.VIEW_SIZE);

        setLayout(null);
        setOpaque(false);

//        Setup badge button

        getBadgeButton().setBounds(BADGE_BUTTON_BOUNDS);

        BadgeButtonController badgeButtonController = new BadgeButtonController(getBadgeButton(), (BadgeListPanel) getListPanel(), this, badge, badgeDetailPanel);
        getBadgeButton().addMouseListener(badgeButtonController);
        getBadgeButton().addMouseMotionListener(badgeButtonController);

        add(getBadgeButton());

        getBadgeButton().repaint();
    }

    public LockableButton getBadgeButton() {
        if (getButton() == null) {
//            int badgeCode = badge.getBadgeCode();
            int badgeCode = ImageContract.A_BADGE;

            setButton(
                    new BadgeButton(
                            badgeCode,
                            Color.WHITE,
                            Color.WHITE,
                            Color.WHITE,
                            Color.WHITE,
                            Screen.SCREEN_BACK_COLOR,
                            BADGE_BUTTON_HOVERED_BACK_COLOR,
                            BADGE_BUTTON_ACTIVED_BACK_COLOR,
                            BADGE_BUTTON_LOCKED_BACK_COLOR,
                            ImageContract.BADGE_BUTTON_LOCKED_IMAGE,
                            DEFAULT_LOCK_STATE
                    ));

            getButton().setPreferredSize(BADGE_BUTTON_SIZE);
            getButton().setMinimumSize(BADGE_BUTTON_SIZE);
            getButton().setMaximumSize(BADGE_BUTTON_SIZE);

        }
        return getButton();
    }
}
