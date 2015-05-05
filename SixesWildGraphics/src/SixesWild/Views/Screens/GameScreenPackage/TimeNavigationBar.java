package SixesWild.Views.Screens.GameScreenPackage;

import SixesWild.Models.Time;
import SixesWild.Views.Application;
import SixesWild.Views.Components.SpecialMoveNavigationBar;

/**
 *
 */
public class TimeNavigationBar extends SpecialMoveNavigationBar {

    TimeProgressBar timeProgressBar;
    Time time;

    public TimeNavigationBar(Application app, int swapSquareSpecialMoveLeft, int resetBoardSpecialMoveLeft, int removeTileSpecialMoveLeft, Time time) {
        super(app, swapSquareSpecialMoveLeft, resetBoardSpecialMoveLeft, removeTileSpecialMoveLeft);
        this.time = time;
    }
}