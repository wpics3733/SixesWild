package model;

/**
 * A tile is the actual data contained by a Square on the board
 * Each tile should always be inside a TileContainer
 * Tiles have a number and a multiplier
 * @author jesse
 *
 */
public class Tile {
	int num;
	int multiplier;
	/*
	 * Make a new Tile with the given number (should be 1..6) and multiplier (1..3)
	 */
	public Tile( int num, int multiplier) {
		this.num = num;
		this.multiplier = multiplier;
	}
	
	/**
	 * Get the number in this tile
	 * @return	the number
	 */
	public int getNum() {
		return num;
	}
	
	/**
	 * get the multiplier associated with this tile
	 * @return	the multiplier
	 */
	public int getMultiplier() {
		return multiplier;
	}

}
