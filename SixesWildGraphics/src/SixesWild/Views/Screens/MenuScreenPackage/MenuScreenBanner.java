package SixesWild.Views.Screens.MenuScreenPackage;

import SixesWild.Views.Application;
import SixesWild.Views.Components.StyledLabel;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class MenuScreenBanner extends JPanel {

    //    Banner title font size
    final float TITLE_FONT_SIZE = 64L;
    //    Banner title text alignment. True when left aligns, and false when center aligns.
    final boolean TITLE_TEXT_ALIGNMENT = false;
    //    Banner title label dimension
    final Dimension TITLE_TEXT_SIZE = new Dimension(Application.WINDOW_WIDTH, 200);
    //    Banner title label bounds
    final int TITLE_TEXT_PADDING_LEFT = 0;
    final int TITLE_TEXT_PADDING_TOP = 0;

    //    Banner bar dimension
    public static final Dimension BANNER_SIZE = new Dimension(Application.WINDOW_WIDTH, 200);

    //    Banner title
    String title;
    //    Banner background color
    Color backColor;

    public MenuScreenBanner(String title, Color backgroundColor) {
        this.backColor = backgroundColor;
        this.title = title;

        setPreferredSize(BANNER_SIZE);

        initialize();
    }

    void initialize() {

        setLayout(null);

        setBackground(backColor);

        StyledLabel bannerTitleLabel = new StyledLabel(title, TITLE_FONT_SIZE, Color.WHITE, TITLE_TEXT_ALIGNMENT);
        bannerTitleLabel.setPreferredSize(TITLE_TEXT_SIZE);

        bannerTitleLabel.setBounds(TITLE_TEXT_PADDING_LEFT, TITLE_TEXT_PADDING_TOP, (int) TITLE_TEXT_SIZE.getWidth(), (int) TITLE_TEXT_SIZE.getHeight());

        add(bannerTitleLabel);
    }
}