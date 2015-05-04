package SixesWild.Models.Levels;

import SixesWild.Models.Value;

/**
 *
 */
public class PuzzleLevel extends Level {

    /**
     *
     */
    String LEVEL_TYPE;
    /**
     *
     */
    Value swapNeighborMoveLeft;

    /**
     *
     */
    public PuzzleLevel() {
    }

    public boolean hasWon() {
        return false;
    }

}