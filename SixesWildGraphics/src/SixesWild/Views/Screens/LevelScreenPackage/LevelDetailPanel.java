package SixesWild.Views.Screens.LevelScreenPackage;

import SixesWild.Contracts.ImageContract;
import SixesWild.Controllers.ViewLevelScreen.StartLevelButtonController;
import SixesWild.Views.Application;
import SixesWild.Views.Components.DetailPanel;
import SixesWild.Views.Components.ImageButton;
import SixesWild.Views.Components.LargeStarsView;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 *
 */
public class LevelDetailPanel extends DetailPanel {


    //    Level name font size
    final float LEVEL_NAME_FONT_SIZE = 36L;

    //    Level name label bounds
    final Rectangle LEVEL_NAME_BOUNDS = new Rectangle(40, 42, 130, 50);

    //    Level type font size
    final float LEVEL_TYPE_FONT_SIZE = 24L;

    //    Level name label bounds
    final Rectangle LEVEL_TYPE_BOUNDS = new Rectangle(40, 72, 130, 50);

    //    Level introduction font size
    final float LEVEL_INTRO_FONT_SIZE = 16L;

    //    Level introduction label bounds
    final Rectangle LEVEL_INTRO_BOUNDS = new Rectangle(170, 20, 550, 100);

    //    Start level button size
    final Dimension START_LEVEL_BUTTON_SIZE = new Dimension(140, 46);

    //    Start level button bounds
    final Rectangle START_LEVEL_BUTTON_BOUNDS = new Rectangle(850, 74, 140, 46);

    //    Star view size
    final Dimension STAR_VIEW_SIZE = new Dimension(96, 28);

    //    Star view bounds
    final Rectangle STAR_VIEW_BOUNDS = new Rectangle(893, 37, 96, 28);


    JLabel levelNameLabel;

    JLabel levelTypeLabel;

    JLabel levelIntroLabel;

    LargeStarsView largeStars;

    ImageButton startLevelButton;

    //    Current font of Text
    Font currentFont;

    public LevelDetailPanel() {

        setLayout(null);
        setBackground(DETAIL_PANEL_BACK_COLOR);

        //       Setup level name label
        setRegularFont(LEVEL_NAME_FONT_SIZE);
        levelNameLabel = new JLabel("Level 1");
        levelNameLabel.setFont(currentFont);
        levelNameLabel.setForeground(Color.WHITE);
        levelNameLabel.setOpaque(false);
        levelNameLabel.setBounds(LEVEL_NAME_BOUNDS);
        add(levelNameLabel);

        //        Setup level type label
        setRegularFont(LEVEL_TYPE_FONT_SIZE);
        levelTypeLabel = new JLabel("Puzzle");
        levelTypeLabel.setFont(currentFont);
        levelTypeLabel.setForeground(Color.WHITE);
        levelTypeLabel.setOpaque(false);
        levelTypeLabel.setBounds(LEVEL_TYPE_BOUNDS);
        add(levelTypeLabel);

        //        Setup level intro label
        setRegularFont(LEVEL_INTRO_FONT_SIZE);
        levelIntroLabel = new JLabel("<html><ul><li>Each move removes squares from grid</li>" +
                "<li>Contents repopulated by shifting downward to fill in holes, with new squares appearing at top</li></ul></html>");
        levelIntroLabel.setFont(currentFont);
        levelIntroLabel.setForeground(Color.WHITE);
        levelIntroLabel.setOpaque(false);
        levelIntroLabel.setBounds(LEVEL_INTRO_BOUNDS);
        add(levelIntroLabel);

        //        Setup level intro label
        startLevelButton = new ImageButton(
                ImageContract.START_LEVEL_BUTTON_NORMAL_IMAGE,
                ImageContract.START_LEVEL_BUTTON_HOVERED_IMAGE,
                ImageContract.START_LEVEL_BUTTON_NORMAL_IMAGE,
                ImageContract.START_LEVEL_BUTTON_NORMAL_IMAGE,
                DETAIL_PANEL_BACK_COLOR,
                DETAIL_PANEL_BACK_COLOR,
                DETAIL_PANEL_BACK_COLOR,
                DETAIL_PANEL_BACK_COLOR
        );

        startLevelButton.setPreferredSize(START_LEVEL_BUTTON_SIZE);
        startLevelButton.setMinimumSize(START_LEVEL_BUTTON_SIZE);
        startLevelButton.setMaximumSize(START_LEVEL_BUTTON_SIZE);

        startLevelButton.setBounds(START_LEVEL_BUTTON_BOUNDS);
        StartLevelButtonController startLevelButtonController = new StartLevelButtonController(startLevelButton);

        startLevelButton.addMouseListener(startLevelButtonController);
        startLevelButton.addMouseMotionListener(startLevelButtonController);

        startLevelButton.repaint();

        add(startLevelButton);



//        Large star view
        largeStars = new LargeStarsView(2);
        largeStars.setPreferredSize(STAR_VIEW_SIZE);
        largeStars.setMaximumSize(STAR_VIEW_SIZE);
        largeStars.setMinimumSize(STAR_VIEW_SIZE);

        largeStars.setBounds(STAR_VIEW_BOUNDS);

        largeStars.repaint();

        add(largeStars);
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