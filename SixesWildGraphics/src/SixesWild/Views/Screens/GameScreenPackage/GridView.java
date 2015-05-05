package SixesWild.Views.Screens.GameScreenPackage;

import SixesWild.Controllers.GameScreen.SquareButtonController;
import SixesWild.Models.Square;
import SixesWild.Models.Tile;
import SixesWild.Views.Application;
import SixesWild.Views.Screens.Screen;
import SixesWild.Views.TransitableView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 */
public class GridView extends TransitableView {

    //    Grid view size
    final Dimension GRID_VIEW_SIZE = new Dimension(654, 654);
    //    Grid view paddings
    final int GRID_VIEW_PADDING_LEFT = 9;
    final int GRID_VIEW_PADDING_TOP = 9;

    final Color SQUARE_NORMAL_BACK_COLOR = new Color(245, 243, 243);
    final Color SQUARE_HOVERED_BACK_COLOR = new Color(250, 212, 0);
    final Color SQUARE_DISABLED_BACK_COLOR = new Color(165, 165, 165);

    ArrayList<Square> squares;
    ArrayList<SquareView> squareViews;
    ArrayList<SquareView> activeSquareViews;
    Application app;

    public GridView(ArrayList<Square> squares, Application app) {
        this.squares = squares;
        this.app = app;

        setPreferredSize(GRID_VIEW_SIZE);
        setMaximumSize(GRID_VIEW_SIZE);
        setMinimumSize(GRID_VIEW_SIZE);

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Screen.BORDER_COLOR));

        initialize();
    }

    public void initialize() {
        setLayout(null);

        squareViews = new ArrayList<SquareView>();
        activeSquareViews = new ArrayList<SquareView>();

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                SquareView squareView;
                if (row == column) {
                    squareView = new SquareView(
                            SQUARE_NORMAL_BACK_COLOR,
                            SQUARE_HOVERED_BACK_COLOR,
                            SQUARE_HOVERED_BACK_COLOR,
                            SQUARE_DISABLED_BACK_COLOR,
                            null,
                            null
                    );
                    squareView.container();
                } else {
                    squareView = new SquareView(
                            SQUARE_NORMAL_BACK_COLOR,
                            SQUARE_HOVERED_BACK_COLOR,
                            SQUARE_HOVERED_BACK_COLOR,
                            SQUARE_DISABLED_BACK_COLOR,
                            null,
                            new Tile()
                    );
                }


                squareView.setPreferredSize(SquareView.SQUARE_VIEW_SIZE);
                squareView.setMaximumSize(SquareView.SQUARE_VIEW_SIZE);
                squareView.setMinimumSize(SquareView.SQUARE_VIEW_SIZE);

                squareView.setBounds(
                        GRID_VIEW_PADDING_LEFT + column * ((int) SquareView.SQUARE_VIEW_SIZE.getWidth() - 1),
                        GRID_VIEW_PADDING_TOP + row * ((int) SquareView.SQUARE_VIEW_SIZE.getHeight() - 1),
                        (int) SquareView.SQUARE_VIEW_SIZE.getWidth(),
                        (int) SquareView.SQUARE_VIEW_SIZE.getHeight()
                );

                add(squareView);

                SquareButtonController squareButtonController = new SquareButtonController(squareView);
                squareView.addMouseListener(squareButtonController);
                squareView.addMouseMotionListener(squareButtonController);

                squareView.repaint();
            }
        }
    }
}