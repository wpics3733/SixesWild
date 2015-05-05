package SixesWild.Views.Screens.GameScreenPackage;

import SixesWild.Models.Square;
import SixesWild.Views.TransitableView;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class SquareView extends JPanel {

    //    Square size
    public static final Dimension SQUARE_VIEW_SIZE = new Dimension(70, 70);

//    Square view background color
    final Color SQUARE_VIEW_BACK_COLOR = new Color(245, 243, 243);

    Square square;
    TileView tileView;

    public SquareView(Square square, TileView tileView) {
        this.square = square;
        this.tileView = tileView;

        setPreferredSize(SQUARE_VIEW_SIZE);
        setMaximumSize(SQUARE_VIEW_SIZE);
        setMinimumSize(SQUARE_VIEW_SIZE);

        setBackground(SQUARE_VIEW_BACK_COLOR);
        setBorder(BorderFactory.createLineBorder(GridView.GRID_BORDER_COLOR));
    }

    @Override
    public void repaint() {
        if (tileView != null) {
            tileView.repaint();
        }
        super.repaint();
    }

}