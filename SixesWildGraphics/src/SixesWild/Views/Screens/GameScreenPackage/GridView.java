package SixesWild.Views.Screens.GameScreenPackage;

import SixesWild.Controllers.GameScreen.SquareButtonController;
import SixesWild.Models.Grid;
import SixesWild.Models.Levels.Level;
import SixesWild.Models.Location;
import SixesWild.Models.Square;
import SixesWild.Moves.ISpecialMove;
import SixesWild.Views.Application;
import SixesWild.Views.Components.NavigationBar;
import SixesWild.Views.IModelUpdated;
import SixesWild.Views.Screens.Screen;
import SixesWild.Views.TransitableView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 */
public class GridView extends TransitableView implements IModelUpdated{

    //    Grid view size
    final Dimension GRID_VIEW_SIZE = new Dimension(654, 654);
    //    Grid view paddings
    final int GRID_VIEW_PADDING_LEFT = 9;
    final int GRID_VIEW_PADDING_TOP = 9;

    final Color SQUARE_NORMAL_BACK_COLOR = new Color(245, 243, 243);
    final Color SQUARE_HOVERED_BACK_COLOR = new Color(250, 212, 0);
    final Color SQUARE_DISABLED_BACK_COLOR = new Color(165, 165, 165);

    ArrayList<SquareView> activeSquareViews;
    ArrayList<SquareView> squareViews;
    Application app;

    Grid grid;
    Level level;

    public GridView(Application app, Level level) {
        this.grid = level.getGrid();
        this.app = app;
        this.level = level;

        setPreferredSize(GRID_VIEW_SIZE);
        setMaximumSize(GRID_VIEW_SIZE);
        setMinimumSize(GRID_VIEW_SIZE);

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Screen.BORDER_COLOR));

        initialize();
    }

    public void initialize() {

        setLayout(null);

        activeSquareViews = new ArrayList<SquareView>();
        squareViews = new ArrayList<SquareView>();

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                Square square = grid.getSquare(row, column);
                if (square != null) {

                    SquareView squareView = new SquareView(
                            SQUARE_NORMAL_BACK_COLOR,
                            SQUARE_HOVERED_BACK_COLOR,
                            SQUARE_HOVERED_BACK_COLOR,
                            SQUARE_DISABLED_BACK_COLOR,
                            square,
                            NavigationBar.NO_ROUND
                    );

                    squareViews.add(squareView);

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

                    SquareButtonController squareButtonController = new SquareButtonController(squareView, this, app);
                    squareView.addMouseListener(squareButtonController);
                    squareView.addMouseMotionListener(squareButtonController);

                    squareView.repaint();
                }
            }
        }
    }

    public void addActiveSquareView(SquareView squareView) {
        activeSquareViews.add(squareView);
        grid.addActiveSquare(squareView.getSquare());
    }

    public void beginMakeingMove() {
        activeSquareViews.clear();
        level.beginMakeingMove();
    }

    public void finishMakingMove() {
        level.finishMakingMove();
        for (Iterator<SquareView> squareViewIterator = activeSquareViews.iterator(); squareViewIterator.hasNext(); ) {

            SquareView squareView = squareViewIterator.next();

            squareView.inactive();
            squareView.normal();
        }

        activeSquareViews.clear();

        grid.getActiveSquare().clear();

        app.getGameScreen().modelChanged();

        if (level.hasWon()) {
            JOptionPane.showMessageDialog(app, "Game over!");
        }
    }

    public boolean isMakeingMove() {
        return level.isMakeingMove();
    }

    public boolean hasSpecialMove() {
        return level.hasSpecialMove();
    }

    public void setSpecialMove(ISpecialMove specialMove) {
        level.setSpecialMove(specialMove);
    }

    public ISpecialMove getSpecialMove() {
        return level.getSpecialMove();
    }

    public Grid getGrid() {
        return grid;
    }

    @Override
    public void modelChanged() {
        for(Iterator<SquareView> squareViewIterator = squareViews.iterator(); squareViewIterator.hasNext();) {
            SquareView squareView = squareViewIterator.next();
            squareView.repaint();
        }
    }
}