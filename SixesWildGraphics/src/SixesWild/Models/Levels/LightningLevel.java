package SixesWild.Models.Levels;

import SixesWild.Models.Time;

/**
 *
 */
public class LightningLevel extends Level {

    /**
     *
     */
    Time time;
    /**
     *
     */
    String LEVEL_TYPE;

    /**
     *
     */
    public LightningLevel() {
    }

    public boolean hasWon() {
        return false;
    }
}