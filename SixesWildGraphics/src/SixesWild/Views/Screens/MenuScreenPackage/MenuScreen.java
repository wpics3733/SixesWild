package SixesWild.Views.Screens.MenuScreenPackage;

import SixesWild.Controllers.MenuScreen.AboutButtonController;
import SixesWild.Controllers.MenuScreen.AchievementButtonController;
import SixesWild.Controllers.MenuScreen.ContinueGameButtonController;
import SixesWild.Controllers.MenuScreen.ViewLevelsButtonController;
import SixesWild.Views.Application;
import SixesWild.Views.Components.TextButton;
import SixesWild.Views.Screens.Screen;

import java.awt.*;

/**
 *
 */
public class MenuScreen extends Screen {

    //    Menu screen banner background color
    final Color BANNER_BACK_COLOR = new Color(112, 147, 113);
    final Rectangle BANNER_BOUNDS = new Rectangle(
            0,
            STATUS_BAR_HEIGHT,
            (int) MenuScreenBanner.BANNER_SIZE.getWidth(),
            (int) MenuScreenBanner.BANNER_SIZE.getHeight()
    );

    //    Banner title
    final String BANNER_TITLE = "SixesWild";

    //    Button background colors
    final Color BUTTON_BACK_COLOR = new Color(115, 146, 116);
    final Color BUTTON_HOVERED_COLOR = new Color(86, 106, 87);

    //    Button font size
    final float BUTTON_FONT_SIZE = 26L;

    //    Button dimension
    final Dimension BUTTON_SIZE = new Dimension(400, 66);
    //    Bounds of buttons
    final int BUTTON_PADDING_LEFT = (Application.WINDOW_WIDTH - (int) BUTTON_SIZE.getWidth()) / 2;

    //    Vertical space between buttons
    final int BUTTON_VERTICAL_SPACE = 6;

    final Rectangle CONTINUE_BUTTON_BOUNDS = new Rectangle(
            BUTTON_PADDING_LEFT,
            STATUS_BAR_HEIGHT + (int) MenuScreenBanner.BANNER_SIZE.getHeight() + 96,
            (int) BUTTON_SIZE.getWidth(),
            (int) BUTTON_SIZE.getHeight()
    );
    final Rectangle LEVEL_BUTTON_BOUNDS = new Rectangle(
            BUTTON_PADDING_LEFT,
            STATUS_BAR_HEIGHT + (int) MenuScreenBanner.BANNER_SIZE.getHeight() + 96 + BUTTON_VERTICAL_SPACE + (int) BUTTON_SIZE.getHeight(),
            (int) BUTTON_SIZE.getWidth(),
            (int) BUTTON_SIZE.getHeight()
    );
    final Rectangle BADGE_BUTTON_BOUNDS = new Rectangle(
            BUTTON_PADDING_LEFT,
            STATUS_BAR_HEIGHT + (int) MenuScreenBanner.BANNER_SIZE.getHeight() + 96 + (BUTTON_VERTICAL_SPACE + (int) BUTTON_SIZE.getHeight()) * 2,
            (int) BUTTON_SIZE.getWidth(),
            (int) BUTTON_SIZE.getHeight()
    );
    final Rectangle ABOUT_BUTTON_BOUNDS = new Rectangle(
            BUTTON_PADDING_LEFT,
            STATUS_BAR_HEIGHT + (int) MenuScreenBanner.BANNER_SIZE.getHeight() + 96 + (BUTTON_VERTICAL_SPACE + (int) BUTTON_SIZE.getHeight()) * 3,
            (int) BUTTON_SIZE.getWidth(),
            (int) BUTTON_SIZE.getHeight()
    );

    //    Text of navigation buttons
    final String CONTINUE_BUTTON_TEXT = "Contiune Game";
    final String LEVEL_BUTTON_TEXT = "View Levels";
    final String BADGE_BUTTON_TEXT = "Achievements";
    final String ABOUT_BUTTON_TEXT = "Developers";

    //    Navigation buttons
    TextButton continueButton;
    TextButton levelsButton;
    TextButton badgeButton;
    TextButton aboutButton;

    public MenuScreen(String title, Application app) {
        super(title, app);

//        Setup banner bar
        MenuScreenBanner bannerBar = new MenuScreenBanner(BANNER_TITLE, BANNER_BACK_COLOR);
        bannerBar.setBounds(BANNER_BOUNDS);
        add(bannerBar);

//        Setup buttons
        getContinueButton().setBounds(CONTINUE_BUTTON_BOUNDS);
        getLevelsButton().setBounds(LEVEL_BUTTON_BOUNDS);
        getBadgeButton().setBounds(BADGE_BUTTON_BOUNDS);
        getAboutButton().setBounds(ABOUT_BUTTON_BOUNDS);

//        Add controller to buttons
        ContinueGameButtonController continueGameButtonController = new ContinueGameButtonController(continueButton);
        getContinueButton().addMouseListener(continueGameButtonController);
        getContinueButton().addMouseMotionListener(continueGameButtonController);

        ViewLevelsButtonController viewLevelsButtonController = new ViewLevelsButtonController(levelsButton);
        getLevelsButton().addMouseListener(viewLevelsButtonController);
        getLevelsButton().addMouseMotionListener(viewLevelsButtonController);

        AchievementButtonController achievementButtonController = new AchievementButtonController(badgeButton);
        getBadgeButton().addMouseListener(achievementButtonController);
        getBadgeButton().addMouseMotionListener(achievementButtonController);

        AboutButtonController aboutButtonController = new AboutButtonController(aboutButton);
        getAboutButton().addMouseListener(aboutButtonController);
        getAboutButton().addMouseMotionListener(aboutButtonController);

//        Add buttons into screen
        add(continueButton);
        add(levelsButton);
        add(badgeButton);
        add(aboutButton);

    }

//    Getters and setters

    public TextButton getContinueButton() {
        if (continueButton == null) {
            continueButton = new TextButton(
                    CONTINUE_BUTTON_TEXT,
                    BUTTON_FONT_SIZE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    BUTTON_BACK_COLOR,
                    BUTTON_HOVERED_COLOR,
                    BUTTON_BACK_COLOR,
                    BUTTON_BACK_COLOR
            );
            continueButton.setPreferredSize(BUTTON_SIZE);
        }

        return continueButton;
    }

    public TextButton getLevelsButton() {
        if (levelsButton == null) {
            levelsButton = new TextButton(
                    LEVEL_BUTTON_TEXT,
                    BUTTON_FONT_SIZE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    BUTTON_BACK_COLOR,
                    BUTTON_HOVERED_COLOR,
                    BUTTON_BACK_COLOR,
                    BUTTON_BACK_COLOR
            );

            levelsButton.setPreferredSize(BUTTON_SIZE);
        }

        return levelsButton;
    }

    public TextButton getBadgeButton() {
        if (badgeButton == null) {
            badgeButton = new TextButton(
                    BADGE_BUTTON_TEXT,
                    BUTTON_FONT_SIZE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    BUTTON_BACK_COLOR,
                    BUTTON_HOVERED_COLOR,
                    BUTTON_BACK_COLOR,
                    BUTTON_BACK_COLOR
            );

            badgeButton.setPreferredSize(BUTTON_SIZE);
        }

        return badgeButton;
    }

    public TextButton getAboutButton() {
        if (aboutButton == null) {
            aboutButton = new TextButton(
                    ABOUT_BUTTON_TEXT,
                    BUTTON_FONT_SIZE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    BUTTON_BACK_COLOR,
                    BUTTON_HOVERED_COLOR,
                    BUTTON_BACK_COLOR,
                    BUTTON_BACK_COLOR
            );

            aboutButton.setPreferredSize(BUTTON_SIZE);
        }
        return aboutButton;
    }
}