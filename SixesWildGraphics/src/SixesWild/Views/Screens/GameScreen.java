package SixesWild.Views.Screens;

import SixesWild.Models.Level;
import SixesWild.Views.*;
import SixesWild.Views.Components.ImageButton;
import SixesWild.Views.Components.PopupBox;

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