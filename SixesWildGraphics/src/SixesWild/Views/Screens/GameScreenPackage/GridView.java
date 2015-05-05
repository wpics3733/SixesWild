package SixesWild.Views.Screens.GameScreenPackage;

import SixesWild.Models.Square;
import SixesWild.Views.Application;
import SixesWild.Views.TransitableView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class GridView extends TransitableView {
    //    Grid border color
    public static final Color GRID_BORDER_COLOR = new Color(229, 229, 229);

    //    Grid view size
    final Dimension GRID_VIEW_SIZE = new Dimension(654, 654);
    //    Grid view paddings
    final int GRID_VIEW_PADDING_LEFT = 9;
    final int GRID_VIEW_PADDING_TOP = 9;

    Color backColor;

    ArrayList<Square> squares;
    ArrayList<SquareView> squareViews;
    ArrayList<TileView> tileViews;
    ArrayList<SquareView> activeSquareViews;
    Application app;

    public GridView(ArrayList<Square> squares, Application app) {
        this.squares = squares;
        this.app = app;

        setPreferredSize(GRID_VIEW_SIZE);
        setMaximumSize(GRID_VIEW_SIZE);
        setMinimumSize(GRID_VIEW_SIZE);

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(GRID_BORDER_COLOR));

        initilize();
    }

    public void initilize() {
        setLayout(null);

        squareViews = new ArrayList<SquareView>();
        tileViews = new ArrayList<TileView>();

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                TileView tileView = new TileView(null);

                int paddingLeft = (int) (SquareView.SQUARE_VIEW_SIZE.getWidth() - TileView.TILE_VIEW_SIZE.getWidth()) / 2 + (int) GameScreen.GRID_VIEW_BOUNDS.getX();
                int paddingTop = (int) (SquareView.SQUARE_VIEW_SIZE.getHeight() - TileView.TILE_VIEW_SIZE.getHeight()) / 2 + (int) GameScreen.GRID_VIEW_BOUNDS.getY();

                tileView.setBounds(
                        paddingLeft + GRID_VIEW_PADDING_LEFT + row * ((int) SquareView.SQUARE_VIEW_SIZE.getWidth() - 1),
                        paddingTop + GRID_VIEW_PADDING_TOP + column * ((int) SquareView.SQUARE_VIEW_SIZE.getHeight() - 1),
                        (int) TileView.TILE_VIEW_SIZE.getWidth(),
                        (int) TileView.TILE_VIEW_SIZE.getHeight()
                );

                SquareView squareView = new SquareView(null, tileView);
                squareView.setBounds(
                        GRID_VIEW_PADDING_LEFT + row * ((int) SquareView.SQUARE_VIEW_SIZE.getWidth() - 1),
                        GRID_VIEW_PADDING_TOP + column * ((int) SquareView.SQUARE_VIEW_SIZE.getHeight() - 1),
                        (int) SquareView.SQUARE_VIEW_SIZE.getWidth(),
                        (int) SquareView.SQUARE_VIEW_SIZE.getHeight()
                );

                squareView.add(tileView);
                add(squareView);
            }
        }
    }

}