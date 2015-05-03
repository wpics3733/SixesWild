package SixesWild.Models;

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