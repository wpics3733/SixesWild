package SixesWild.Models.Levels;

import SixesWild.Models.Square;

/**
 *
 */
public class ReleaseLevel extends Level {

    /**
     *
     */
    Square[] sixReceivers;
    /**
     *
     */
    String LEVEL_TYPE;

    /**
     *
     */
    public ReleaseLevel() {
    }

    public boolean hasWon() {
        return false;
    }
}