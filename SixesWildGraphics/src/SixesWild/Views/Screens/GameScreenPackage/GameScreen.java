package SixesWild.Views.Screens.GameScreenPackage;

import SixesWild.Contracts.ImageContract;
import SixesWild.Contracts.TipContract;
import SixesWild.Controllers.GameScreen.RestartLevelController;
import SixesWild.Models.Levels.Level;
import SixesWild.Views.Application;
import SixesWild.Views.Components.ImageButton;
import SixesWild.Views.Components.PopupBox;
import SixesWild.Views.Screens.NavigableScreen;

import java.awt.*;

/**
 *
 */
public class GameScreen extends NavigableScreen {

    //    Grid view bounds
    public static final Rectangle GRID_VIEW_BOUNDS = new Rectangle(192, NAV_BAR_HEIGHT + STATUS_BAR_HEIGHT + 20, 640, 640);

    //    Reset button size
    final Dimension RESET_BUTTON_SIZE = new Dimension(78, 78);
    //    Reset button bounds
    final Rectangle RESET_BUTTON_BOUNDS = new Rectangle(98, Application.WINDOW_HEIGHT - 21 - 78, 640, 640);

    //    Background color of reset button
    final Color RESET_BUTTON_BACK_COLOR = new Color(112, 147, 113);
    //    Reset button actived background color
    final Color RESET_BUTTON__ACTIVE_COLOR = new Color(86, 116, 87);

    Level level;
    SquareView[] activeSquareViews;
    ScoreLevelView scoreLevelView;
    PopupBox popupBox;
    ImageButton refreshButton;
    GridView gridView;

    public GameScreen(String title, Application app) {

        super(title, app);

        initialize();
    }

    public void initialize() {

        setLayout(null);

        getGridView().setBounds(GRID_VIEW_BOUNDS);
        add(getGridView());

        getRefreshButton().setBounds(RESET_BUTTON_BOUNDS);

        RestartLevelController restartLevelController = new RestartLevelController(getRefreshButton());
        getRefreshButton().addMouseListener(restartLevelController);
        getRefreshButton().addMouseMotionListener(restartLevelController);
        getRefreshButton().setToolTipText(TipContract.RESTART_LEVEL_BUTTON_TIP);

        add(getRefreshButton());

        getRefreshButton().repaint();
    }

    public GridView getGridView() {
        if (gridView == null) {
            gridView = new GridView(null, app);
        }

        return gridView;
    }

    public ImageButton getRefreshButton() {
        if (refreshButton == null) {
            refreshButton = new ImageButton(
                    ImageContract.RESET_BUTTON_IMAGE,
                    ImageContract.RESET_BUTTON_IMAGE,
                    ImageContract.RESET_BUTTON_IMAGE,
                    ImageContract.RESET_BUTTON_IMAGE,
                    RESET_BUTTON_BACK_COLOR,
                    RESET_BUTTON__ACTIVE_COLOR,
                    RESET_BUTTON_BACK_COLOR,
                    RESET_BUTTON_BACK_COLOR
            );

            refreshButton.setPreferredSize(RESET_BUTTON_SIZE);
            refreshButton.setMaximumSize(RESET_BUTTON_SIZE);
            refreshButton.setMinimumSize(RESET_BUTTON_SIZE);
        }
        return refreshButton;
    }
}