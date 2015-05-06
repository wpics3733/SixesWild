package SixesWild.Views;

import SixesWild.Models.*;
import SixesWild.Models.Levels.Probabilities;
import SixesWild.Models.Levels.PuzzleLevel;
import SixesWild.Moves.ISpecialMove;
import SixesWild.Utilities;
import SixesWild.Views.Animation.AnimationManager;
import SixesWild.Views.Screens.AboutScreenPackage.AboutScreen;
import SixesWild.Views.Screens.BadgeScreenPackage.BadgesScreen;
import SixesWild.Views.Screens.GameScreenPackage.GameScreen;
import SixesWild.Views.Screens.LevelScreenPackage.LevelsScreen;
import SixesWild.Views.Screens.MenuScreenPackage.MenuScreen;
import SixesWild.Views.Screens.Screen;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

/**
 *
 */
public class Application extends JFrame {

    //    Application name
    public static final String APP_NAME = "SixesWild";

    //    window padding top
    public static final int WINDOW_PADDING_TOP = 0;
    //    window padding left
    public static final int WINDOW_PADDING_LEFT = 0;

    //    window width
    public static final int WINDOW_WIDTH = 1024;
    //    windows height
    public static final int WINDOW_HEIGHT = 768;

    //    Root path of application
    public static final String ROOT_PATH = "user.dir";

    //    Font locations of regular, italic and bold.
    public static final String REGULAR_FONT_LOCATION = "/assets/AvenirNextRegular.ttf";
    public static final String ITALIC_FONT_LOCATION = "/assets/AvenirNextIt.ttf";
    public static final String BOLD_FONT_LOCATION = "/assets/AvenirNextBold.ttf";

    //    Application running state. 0 when execution when fine.
    public static final int EXECUTION_FINE = 0;

    //    Title of application
    final String APPLICATION_TITLE = "SixesWild";

    //    Title of individual screens
    final String ABOUT_SCREEN_TITLE = "Developers";
    final String LEVELS_SCREEN_TITLE = "Levels";
    final String BADGE_SCREEN_TITLE = "Achievement Badges";
    //    Default Screen paddings
    final int DEFAULT_SCREEN_PADDING_LEFT = 0;
    final int DEFAULT_SCREEN_PADDING_TOP = 0;

    //    Screens
    MenuScreen menuScreen;
    GameScreen gameScreen;
    BadgesScreen badgesScreen;
    LevelsScreen levelsScreen;
    AboutScreen aboutScreen;

    JLayeredPane layeredPane;

    //    Current screen
    Screen currentScreen;

    //    Animation manager
    AnimationManager animationManager;

    public Application() {
        super(Application.APP_NAME);
        Utilities.loadFont();

        this.setSize(Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT));
        this.setContentPane(layeredPane);

        this.setLayout(null);

        getMenuScreen().setBounds(DEFAULT_SCREEN_PADDING_LEFT, DEFAULT_SCREEN_PADDING_TOP, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
        this.add(menuScreen);

        currentScreen = menuScreen;
    }

    public void switchTo(Screen screen) {
        if (currentScreen != null && screen != null) {
            getGraphics().clearRect(0, 0, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
            screen.setVisible(true);
            currentScreen.setVisible(false);
            currentScreen = screen;
            repaint();
        }
    }

//    Getters

    public MenuScreen getMenuScreen() {
        if (menuScreen == null) {
            menuScreen = new MenuScreen(APPLICATION_TITLE, this);
        }

        return menuScreen;
    }

    public GameScreen getGameScreen() {
        if (gameScreen == null) {
            gameScreen = new GameScreen(APPLICATION_TITLE, this, generateDummyPuzzleLevel());

            getGameScreen().setBounds(DEFAULT_SCREEN_PADDING_LEFT, DEFAULT_SCREEN_PADDING_TOP, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
            this.add(gameScreen);
            getGameScreen().setVisible(false);
        }

        return gameScreen;
    }

    public BadgesScreen getBadgesScreen() {
        if (badgesScreen == null) {
            badgesScreen = new BadgesScreen(APPLICATION_TITLE, this, BADGE_SCREEN_TITLE);

            getBadgesScreen().setBounds(DEFAULT_SCREEN_PADDING_LEFT, DEFAULT_SCREEN_PADDING_TOP, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
            this.add(badgesScreen);
            getGameScreen().setVisible(false);
        }

        return badgesScreen;
    }

    public LevelsScreen getLevelsScreen() {
        if (levelsScreen == null) {
            levelsScreen = new LevelsScreen(APPLICATION_TITLE, this, LEVELS_SCREEN_TITLE);

            getLevelsScreen().setBounds(DEFAULT_SCREEN_PADDING_LEFT, DEFAULT_SCREEN_PADDING_TOP, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
            this.add(levelsScreen);
            getLevelsScreen().setVisible(false);
        }

        return levelsScreen;
    }

    public AboutScreen getAboutScreen() {
        if (aboutScreen == null) {
            aboutScreen = new AboutScreen(APPLICATION_TITLE, this, ABOUT_SCREEN_TITLE);

            getAboutScreen().setBounds(DEFAULT_SCREEN_PADDING_LEFT, DEFAULT_SCREEN_PADDING_TOP, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
            this.add(aboutScreen);
            getAboutScreen().setVisible(false);
        }
        return aboutScreen;
    }

    public AnimationManager getAnimationManager() {
        if (animationManager == null) {
            animationManager = new AnimationManager();
        }

        return animationManager;
    }

    PuzzleLevel generateDummyPuzzleLevel() {
        boolean unlockState=false;
        Value id = new Value(1);
        Score score = new Score(
                new Value(2000),
                new Value(7000),
                new Value(10000)
        );

        Probabilities probabilities = new Probabilities(
                new Value(10),
                new Value(20),
                new Value(50),
                new Value(70),
                new Value(100),
                new Value(10),
                new Value(30),
                new Value(100)
        );


        Grid grid = new Grid(probabilities);

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                Location location = new Location(new Value(row),new Value(column));
                Square square = new Square(location, null);

                grid.addSquare(square);
            }
        }

        grid.removeSquare(0,0);
        grid.removeSquare(5,7);
        grid.removeSquare(8,4);
        grid.removeSquare(8,3);

        grid.generateTiles();

        SpecialMoveLeft specialMoveLeft = new SpecialMoveLeft(
                new Value(5),
                new Value(6),
                new Value(7)
        );

        Value swapNeighborMoveLeft = new Value(20);

        PuzzleLevel puzzleLevel = new PuzzleLevel(
                unlockState,
                id,
                score,
                grid,
                specialMoveLeft,
                probabilities,
                swapNeighborMoveLeft
        );

        return puzzleLevel;
    }
}