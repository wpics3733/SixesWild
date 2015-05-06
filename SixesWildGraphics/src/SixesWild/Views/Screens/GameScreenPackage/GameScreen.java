package SixesWild.Views.Screens.GameScreenPackage;

import SixesWild.Contracts.ImageContract;
import SixesWild.Contracts.TextContact;
import SixesWild.Contracts.TipContract;
import SixesWild.Controllers.GameScreen.RestartLevelController;
import SixesWild.Models.Levels.EliminationLevel;
import SixesWild.Models.Levels.Level;
import SixesWild.Models.Levels.LightningLevel;
import SixesWild.Models.Levels.PuzzleLevel;
import SixesWild.Models.Levels.ReleaseLevel;
import SixesWild.Models.Value;
import SixesWild.Moves.ISpecialMove;
import SixesWild.Views.Application;
import SixesWild.Views.Components.ImageButton;
import SixesWild.Views.Components.LevelNavigationBar;
import SixesWild.Views.Components.PopupBox;
import SixesWild.Views.Components.ScoreSpecialMoveNavigationBar;
import SixesWild.Views.IModelUpdated;
import SixesWild.Views.Screens.NavigableScreen;

import java.awt.*;

/**
 *
 */
public class GameScreen extends NavigableScreen implements IModelUpdated{
    //    Refresh button round
    final int RESET_BUTTON_ROUND = 10;

    //    Grid view bounds
    public static final Rectangle GRID_VIEW_BOUNDS = new Rectangle(192, NAV_BAR_HEIGHT + STATUS_BAR_HEIGHT + 20, 640, 640);

    //    Score progress view bounds
    public static final Rectangle SCORE_PROGRESS_VIEW_BOUNDS = new Rectangle(50, NAV_BAR_HEIGHT + STATUS_BAR_HEIGHT + 20, 126, 562);

    //    Score progress view size
    public static final Dimension SCORE_PROGRESS_VIEW_SIZE = new Dimension(126, 562);

    //    Reset button size
    final Dimension RESET_BUTTON_SIZE = new Dimension(78, 78);
    //    Reset button bounds
    final Rectangle RESET_BUTTON_BOUNDS = new Rectangle(98, Application.WINDOW_HEIGHT - 21 - 78, 78, 78);

    //    Background color of reset button
    final Color RESET_BUTTON_BACK_COLOR = new Color(112, 147, 113);
    //    Reset button actived background color
    final Color RESET_BUTTON__ACTIVE_COLOR = new Color(86, 116, 87);

    Level level;
    ScoreProgressView scoreProgressView;
    PopupBox popupBox;
    ImageButton refreshButton;
    GridView gridView;

    public GameScreen(String title, Application app, Level level) {

        super(title, app);

        this.level = level;

        initialize();
    }

    public void initialize() {

        setLayout(null);

        remove(getNavigationBar());

        if(!(level instanceof LightningLevel)) {
            LevelNavigationBar levelNavigationBar = null;
            if (level instanceof PuzzleLevel) {
                levelNavigationBar = new LevelNavigationBar(
                        app,
                        level.getSpecialMoveLeft(),
                        level.getScore(),
                        ((PuzzleLevel) level).getSwapNeighborMoveLeft(),
                        TextContact.MOVE_LEFT_LABEL_TEXT,
                        level.getId()
                );
            } else if(level instanceof EliminationLevel) {
                levelNavigationBar = new LevelNavigationBar(
                        app,
                        level.getSpecialMoveLeft(),
                        level.getScore(),
                        ((EliminationLevel)level).getNotMakred(),
                        TextContact.NOT_MARKED_LABEL_TEXT,
                        level.getId()
                );
            } else if(level instanceof ReleaseLevel) {
                levelNavigationBar = new LevelNavigationBar(
                        app,
                        level.getSpecialMoveLeft(),
                        level.getScore(),
                        ((ReleaseLevel) level).getNumNotEmpty(),
                        TextContact.EMPTY_LABEL_TEXT,
                        level.getId()
                );
            }

            if(levelNavigationBar != null) {
                setNavigationBar(levelNavigationBar);
                levelNavigationBar.setBounds(NAV_BAR_BOUNDS);
                add(levelNavigationBar);
            }
        }

//        Setup score progress view
        add(getScoreProgressView());
        getScoreProgressView().initialize();
//        Setup grid view
        getGridView().setBounds(GRID_VIEW_BOUNDS);
        add(getGridView());

        getRefreshButton().setBounds(RESET_BUTTON_BOUNDS);

        RestartLevelController restartLevelController = new RestartLevelController(getRefreshButton(),this);
        getRefreshButton().addMouseListener(restartLevelController);
        getRefreshButton().addMouseMotionListener(restartLevelController);
        getRefreshButton().setToolTipText(TipContract.RESTART_LEVEL_BUTTON_TIP);

        add(getRefreshButton());

        getRefreshButton().repaint();

    }

    public GridView getGridView() {
        if (gridView == null) {
            gridView = new GridView(app, level);
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
                    RESET_BUTTON_BACK_COLOR,
                    RESET_BUTTON_ROUND

            );

            refreshButton.setPreferredSize(RESET_BUTTON_SIZE);
            refreshButton.setMaximumSize(RESET_BUTTON_SIZE);
            refreshButton.setMinimumSize(RESET_BUTTON_SIZE);
        }
        return refreshButton;
    }

    public ScoreProgressView getScoreProgressView() {
        if (scoreProgressView == null) {
            scoreProgressView = new ScoreProgressView(level.getScore());
            scoreProgressView.setBounds(SCORE_PROGRESS_VIEW_BOUNDS);
        }
        return scoreProgressView;
    }

    public void updateScore(Value amount) {
        level.getScore().getCurrentScore().increase(amount.getValue());
        getScoreProgressView().modelChanged();
        modelChanged();
    }

    @Override
    public void modelChanged() {
        ((ScoreSpecialMoveNavigationBar)getNavigationBar()).modelChanged();
    }

    public void restartLevel() {
        level.restart();
        gridView.modelChanged();
        modelChanged();
    }
}