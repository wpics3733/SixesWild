package SixesWild.Views.Components;

import SixesWild.Contracts.ImageContract;
import SixesWild.Contracts.TipContract;
import SixesWild.Controllers.StatusBar.CloseWindowButtonController;
import SixesWild.Views.Application;

import javax.swing.*;
import java.awt.*;

/**
 * Created by harryliu on 5/2/15.
 */
public class StatusBar extends JPanel {

    //    Background color of status bar
    final Color BACK_COLOR = new Color(90, 127, 92);
    //    Close window button actived background color
    final Color CLOSE_WINDOWS_BUTTON_ACTIVE_COLOR = new Color(86, 116, 87);
    //    Close window button size
    final Dimension CLOSE_WINDOW_BUTTON_DIMENSION = new Dimension(46, 30);
    //    Close button bounds
    final Rectangle CLOSE_WINDOW_BUTTON_BOUNDS = new Rectangle(
            Application.WINDOW_WIDTH - (int) CLOSE_WINDOW_BUTTON_DIMENSION.getWidth(),
            0,
            (int) CLOSE_WINDOW_BUTTON_DIMENSION.getWidth(),
            (int) CLOSE_WINDOW_BUTTON_DIMENSION.getHeight());

    //    Title font size
    final float TITLE_FONT_SIZE = 20L;
    //    Title label size
    final Dimension TITLE_LABEL_DIMENSION = new Dimension(210, 30);
    //    Title label bounds
    final Rectangle TITLE_LABEL_BOUNDS = new Rectangle(20, 0, 210, 30);
    //    Title label alignment
    final boolean TITLE_LABEL_LEFT_ALIGN = true;

    //    Status bar title
    String title;

    //    Close window button
    ImageButton closeButton;
    //     Title label
    StyledLabel titleLabel;

    public StatusBar(String title) {
        this.title = title;
        initialize();
    }

    void initialize() {
        this.setLayout(null);

//        Title label settings
        titleLabel = new StyledLabel(this.title, TITLE_FONT_SIZE, Color.WHITE, TITLE_LABEL_LEFT_ALIGN);

        titleLabel.setMaximumSize(TITLE_LABEL_DIMENSION);
        titleLabel.setMinimumSize(TITLE_LABEL_DIMENSION);
        titleLabel.setPreferredSize(TITLE_LABEL_DIMENSION);

        titleLabel.setBounds(TITLE_LABEL_BOUNDS);

//        Close button settings
        closeButton = new ImageButton(
                ImageContract.CLOSE_WINDOWS_BUTTON_IMAGE,
                ImageContract.CLOSE_WINDOWS_BUTTON_IMAGE,
                ImageContract.CLOSE_WINDOWS_BUTTON_IMAGE,
                ImageContract.CLOSE_WINDOWS_BUTTON_IMAGE,
                BACK_COLOR,
                CLOSE_WINDOWS_BUTTON_ACTIVE_COLOR,
                BACK_COLOR,
                BACK_COLOR,
                NavigationBar.NO_ROUND
        );

        closeButton.setPreferredSize(CLOSE_WINDOW_BUTTON_DIMENSION);
        closeButton.setMinimumSize(CLOSE_WINDOW_BUTTON_DIMENSION);
        closeButton.setMaximumSize(CLOSE_WINDOW_BUTTON_DIMENSION);

        closeButton.setBounds(CLOSE_WINDOW_BUTTON_BOUNDS);
        closeButton.setToolTipText(TipContract.CLOSE_WINDOW_BUTTON_TIP);

//        Events for closeButton
        CloseWindowButtonController closeButtonController = new CloseWindowButtonController(closeButton);
        closeButton.addMouseListener(closeButtonController);
        closeButton.addMouseMotionListener(closeButtonController);

        setBackground(BACK_COLOR);

        add(titleLabel);
        titleLabel.repaint();

        add(closeButton);

        closeButton.repaint();
    }
}
