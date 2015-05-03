package SixesWild.Views.Components;

import SixesWild.Contracts.ImageContract;
import SixesWild.Contracts.TipContract;
import SixesWild.Views.Application;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class NavigationBar extends JPanel {

    //    Back button
    ImageButton backButton;

    //    Button background color
    final Color BUTTON_BACK_COLOR = new Color(90, 127, 92);
    //  Button actived background color
    final Color BUTTON_ACTIVE_COLOR = new Color(86, 116, 87);
    //    Back button dimension
    final Dimension BACK_BUTTON_SIZE = new Dimension(27, 28);
    //    Navigation bar background color
    final Color Nav_BAR_COLOR = new Color(112, 147, 113);

    public NavigationBar() {
        initialize();
    }

    void initialize() {
        setBackground(Nav_BAR_COLOR);
        setLayout(null);

        backButton = new ImageButton(
                ImageContract.BACK_BUTTON_IMAGE,
                ImageContract.BACK_BUTTON_IMAGE,
                ImageContract.BACK_BUTTON_IMAGE,
                ImageContract.BACK_BUTTON_IMAGE,
                BUTTON_BACK_COLOR,
                BUTTON_ACTIVE_COLOR,
                BUTTON_BACK_COLOR,
                BUTTON_BACK_COLOR);

        backButton.setPreferredSize(BACK_BUTTON_SIZE);
        backButton.setToolTipText(TipContract.BACK_TO_MAIN_MENU_BUTTON_TIP);

    }
}