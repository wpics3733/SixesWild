package SixesWild.Models;

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