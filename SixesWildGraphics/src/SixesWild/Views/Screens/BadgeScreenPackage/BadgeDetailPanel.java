package SixesWild.Views.Screens.BadgeScreenPackage;

import SixesWild.Contracts.ImageContract;
import SixesWild.Controllers.ViewBadgeScreen.ResetBadgeButtonController;
import SixesWild.Views.Application;
import SixesWild.Views.Components.DetailPanel;
import SixesWild.Views.Components.ImageButton;
import SixesWild.Views.Components.NavigationBar;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 *
 */
public class BadgeDetailPanel extends DetailPanel {

    //    Badge canvas size
    final Dimension BADGE_CANVAS_SIZE = new Dimension(82, 82);
    //    Badge canvas bounds
    final Rectangle BADGE_CANVAS_BOUNDS = new Rectangle(42, 38, 82, 82);

    //    Badge name font size
    final float BADGE_NAME_FONT_SIZE = 26L;

    //    Badge name label bounds
    final Rectangle BADGE_NAME_BOUNDS = new Rectangle(186, 22, 162, 40);

    //    Badge introduction font size
    final float BADGE_INTRO_FONT_SIZE = 20L;

    //    Badge introduction label bounds
    final Rectangle BADGE_INTRO_BOUNDS = new Rectangle(186, 60, 500, 40);

    //    Reset badge button size
    final Dimension BADGE_RESET_BUTTON_SIZE = new Dimension(254, 46);

    //     Reset badge button bounds
    final Rectangle BADGE_RESET_BUTTON_BOUNDS = new Rectangle(744, 55, 254, 46);

    BadgeCanvas badgeCanvas;

    JLabel badgeNameLabel;

    JLabel badgeIntroLabel;

    ImageButton resetBadgeButton;

    //    Current font of Text
    Font currentFont;

    public BadgeDetailPanel() {
        initialize();
    }

    void initialize() {
        setLayout(null);
        setBackground(DetailPanel.DETAIL_PANEL_BACK_COLOR);

//        Badge canvas

        badgeCanvas = new BadgeCanvas(ImageContract.BADGE_IMAGE_LIST[2]);

        badgeCanvas.setPreferredSize(BADGE_CANVAS_SIZE);
        badgeCanvas.setMaximumSize(BADGE_CANVAS_SIZE);
        badgeCanvas.setMinimumSize(BADGE_CANVAS_SIZE);

        badgeCanvas.setBounds(BADGE_CANVAS_BOUNDS);

        add(badgeCanvas);

        badgeCanvas.repaint();

        //       Setup badge name label
        setRegularFont(BADGE_NAME_FONT_SIZE);
        badgeNameLabel = new JLabel("Sixes Master");
        badgeNameLabel.setFont(currentFont);
        badgeNameLabel.setForeground(Color.WHITE);
        badgeNameLabel.setOpaque(false);
        badgeNameLabel.setBounds(BADGE_NAME_BOUNDS);
        add(badgeNameLabel);

        //        Setup badge type label
        setRegularFont(BADGE_INTRO_FONT_SIZE);
        badgeIntroLabel = new JLabel("Successfully remove all tails in 20 moves");
        badgeIntroLabel.setFont(currentFont);
        badgeIntroLabel.setForeground(Color.WHITE);
        badgeIntroLabel.setOpaque(false);
        badgeIntroLabel.setBounds(BADGE_INTRO_BOUNDS);
        add(badgeIntroLabel);

        resetBadgeButton = new ImageButton(
                ImageContract.BADGE_RESET_BUTTON_NORMAL_IMAGE,
                ImageContract.BADGE_RESET_BUTTON_HOVERED_IMAGE,
                ImageContract.BADGE_RESET_BUTTON_NORMAL_IMAGE,
                ImageContract.BADGE_RESET_BUTTON_NORMAL_IMAGE,
                DetailPanel.DETAIL_PANEL_BACK_COLOR,
                DetailPanel.DETAIL_PANEL_BACK_COLOR,
                DetailPanel.DETAIL_PANEL_BACK_COLOR,
                DetailPanel.DETAIL_PANEL_BACK_COLOR,
                NavigationBar.NO_ROUND
        );

        resetBadgeButton.setPreferredSize(BADGE_RESET_BUTTON_SIZE);
        resetBadgeButton.setMaximumSize(BADGE_RESET_BUTTON_SIZE);
        resetBadgeButton.setMinimumSize(BADGE_RESET_BUTTON_SIZE);

        resetBadgeButton.setBounds(BADGE_RESET_BUTTON_BOUNDS);

        ResetBadgeButtonController resetBadgeButtonController = new ResetBadgeButtonController(resetBadgeButton);
        resetBadgeButton.addMouseListener(resetBadgeButtonController);
        resetBadgeButton.addMouseMotionListener(resetBadgeButtonController);

        add(resetBadgeButton);

        resetBadgeButton.repaint();


    }

    public void setRegularFont(float fontSize) {

        //  Setup font
        Font font;

        try {

            font = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty(Application.ROOT_PATH) + Application.REGULAR_FONT_LOCATION));
            font = font.deriveFont(fontSize);
            currentFont = font;

        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }

    public void setItalicFont(float fontSize) {


        //  Setup font
        Font font;

        try {

            font = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty(Application.ROOT_PATH) + Application.ITALIC_FONT_LOCATION));
            font = font.deriveFont(fontSize);
            currentFont = font;

        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }

    public void setBoldFont(float fontSize) {

        //  Setup font
        Font font;

        try {

            font = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty(Application.ROOT_PATH) + Application.BOLD_FONT_LOCATION));
            font = font.deriveFont(fontSize);
            currentFont = font;

        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}