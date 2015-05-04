package SixesWild.Views.Screens.GameScreenPackage;

import SixesWild.Models.Levels.Level;
import SixesWild.Views.*;
import SixesWild.Views.Components.ImageButton;
import SixesWild.Views.Components.PopupBox;
import SixesWild.Views.Screens.NavigableScreen;

/**
 *
 */
public class GameScreen extends NavigableScreen {

    /**
     *
     */
    Level level;
    /**
     *
     */
    SquareView[] activeSquareViews;
    /**
     *
     */
    ScoreLevelView scoreLevelView;
    /**
     *
     */
    PopupBox popupBox;
    /**
     *
     */
    ImageButton refreshButton;

    /**
     *
     */
    public GameScreen(String title, Application app) {

        super(title, app);
    }


}