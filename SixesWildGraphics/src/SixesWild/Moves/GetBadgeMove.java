package SixesWild.Moves;

import SixesWild.Models.Levels.Level;
import SixesWild.Views.Application;

/**
 *
 */
public class GetBadgeMove implements IMove {


    Level level;

    public GetBadgeMove(Level level) {
        this.level = level;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public boolean doMove(Application app) {
        return false;
    }
}