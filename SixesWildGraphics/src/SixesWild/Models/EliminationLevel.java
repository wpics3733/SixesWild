package SixesWild.Models;

/**
 *
 */
public class EliminationLevel extends Level {

    /**
     *
     */
    Square[] markedSquares;
    /**
     *
     */
    String LEVEL_TYPE;

    /**
     *
     */
    public EliminationLevel() {
    }

    public boolean hasWon() {
        return false;
    }

}