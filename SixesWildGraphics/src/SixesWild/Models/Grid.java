package SixesWild.Models;

import SixesWild.Models.Levels.Probabilities;
import SixesWild.Utilities;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 */
public class Grid {

    //    Max number of rows
    public static final int MAX_ROWS = 9;
    //    Max number of columns
    public static final int MAX_COLUMNS = 9;

    //   Max number of tile
    public static final int MAX_TILES = MAX_COLUMNS * MAX_ROWS;


    Square[][] squares;
    ArrayList<Square> activeSquare;
    Probabilities probabilities;

    public Grid(Probabilities probabilities) {
        this.probabilities = probabilities;
        squares = new Square[MAX_ROWS][MAX_COLUMNS];
        activeSquare = new ArrayList<Square>();
    }

    public void initialize() {
        for (int row = 0; row < MAX_ROWS; row++) {
            for (int column = 0; column < MAX_COLUMNS; column++) {

                Value rowValue = new Value(row);
                Value columnValue = new Value(column);

                Location location = new Location(rowValue, columnValue);
                squares[row][column] = new Square(location, null);
            }
        }
    }

    public void addSquare(Square square) {
        Location location = square.getLocation();
        squares[(int) location.getRow().getValue()][(int) location.getColumn().getValue()] = square;
    }

    public void removeSquare(int row, int column) {
        Location location = new Location(new Value(row), new Value(column));
        squares[(int) location.getRow().getValue()][(int) location.getColumn().getValue()] = null;
    }

    public Square getSquare(int row, int column) {
        return squares[row][column];
    }

    public void generateTiles() {
        for (int row = 0; row < MAX_ROWS; row++) {
            for (int column = 0; column < MAX_COLUMNS; column++) {
                if (squares[row][column] != null && squares[row][column].isEmpty() && !squares[row][column].isContainer()) {

//                    Generate multiplier
                    BonusMultiplier multiplier = null;

                    Random random = new Random();
                    int randomInt = random.nextInt(Utilities.ONE_HUNDRED);
                    if (randomInt <= probabilities.getMultiplierOne().getValue()) {
                        multiplier = new BonusMultiplier(new Value(Utilities.ONE));

                    } else if (randomInt > probabilities.getMultiplierOne().getValue()
                            && randomInt <= probabilities.getMultiplierTwo().getValue()) {

                        multiplier = new BonusMultiplier(new Value(Utilities.TWO));

                    } else if (randomInt > probabilities.getMultiplierTwo().getValue()
                            && randomInt <= probabilities.getMultiplierThree().getValue()) {
                        multiplier = new BonusMultiplier(new Value(Utilities.THREE));
                    }

//                    Generate tile
                    Tile tile = null;

                    random = new Random();
                    randomInt = random.nextInt(Utilities.ONE_HUNDRED);

                    if (randomInt <= probabilities.getTileOne().getValue()) {

                        tile = new Tile(new Value(Utilities.ONE), multiplier);

                    } else if (randomInt > probabilities.getTileOne().getValue()
                            && randomInt <= probabilities.getTileTwo().getValue()) {

                        tile = new Tile(new Value(Utilities.TWO), multiplier);

                    } else if (randomInt > probabilities.getTileTwo().getValue()
                            && randomInt <= probabilities.getTileThree().getValue()) {

                        tile = new Tile(new Value(Utilities.THREE), multiplier);

                    } else if (randomInt > probabilities.getTileThree().getValue()
                            && randomInt <= probabilities.getTileFour().getValue()) {

                        tile = new Tile(new Value(Utilities.FOUR), multiplier);

                    } else if (randomInt > probabilities.getTileFour().getValue() && randomInt <= probabilities.getTileFive().getValue()) {

                        tile = new Tile(new Value(Utilities.FIVE), multiplier);
                    }

                    squares[row][column].setTile(tile);

                }
            }
        }
    }

    public void reset() {
        for (int row = 0; row < MAX_ROWS; row++) {
            for (int column = 0; column < MAX_COLUMNS; column++) {
                if (squares[row][column] != null) {

                    //                    Generate multiplier
                    BonusMultiplier multiplier = null;

                    Random random = new Random();
                    int randomInt = random.nextInt(Utilities.ONE_HUNDRED);
                    if (randomInt <= probabilities.getMultiplierOne().getValue()) {
                        multiplier = new BonusMultiplier(new Value(Utilities.ONE));

                    } else if (randomInt > probabilities.getMultiplierOne().getValue()
                            && randomInt <= probabilities.getMultiplierTwo().getValue()) {

                        multiplier = new BonusMultiplier(new Value(Utilities.TWO));

                    } else if (randomInt > probabilities.getMultiplierTwo().getValue()
                            && randomInt <= probabilities.getMultiplierThree().getValue()) {
                        multiplier = new BonusMultiplier(new Value(Utilities.THREE));
                    }

//                    Generate tile
                    Tile tile = null;

                    random = new Random();
                    randomInt = random.nextInt(Utilities.ONE_HUNDRED);

                    if (randomInt <= probabilities.getTileOne().getValue()) {

                        tile = new Tile(new Value(Utilities.ONE), multiplier);

                    } else if (randomInt > probabilities.getTileOne().getValue()
                            && randomInt <= probabilities.getTileTwo().getValue()) {

                        tile = new Tile(new Value(Utilities.TWO), multiplier);

                    } else if (randomInt > probabilities.getTileTwo().getValue()
                            && randomInt <= probabilities.getTileThree().getValue()) {

                        tile = new Tile(new Value(Utilities.THREE), multiplier);

                    } else if (randomInt > probabilities.getTileThree().getValue()
                            && randomInt <= probabilities.getTileFour().getValue()) {

                        tile = new Tile(new Value(Utilities.FOUR), multiplier);

                    } else if (randomInt > probabilities.getTileFour().getValue() && randomInt <= probabilities.getTileFive().getValue()) {

                        tile = new Tile(new Value(Utilities.FIVE), multiplier);
                    }

                    squares[row][column].setTile(tile);
                }
            }
        }
    }

    public void addActiveSquare(Square square) {
        activeSquare.add(square);
    }

    public void clearActiveSquares() {
        activeSquare.clear();
    }

    public ArrayList<Square> getActiveSquare() {
        return activeSquare;
    }
}