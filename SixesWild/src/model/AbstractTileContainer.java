package model;

/**
 * The abstract representation of a TileContainer in the Board.
 * Some tileContainers are null, some are buckets, but all have 
 * an x and a y, can be adjacent to other tiles, and have knowledge
 * of whether you can add things to them
 * @author jesse
 *
 */
public abstract class AbstractTileContainer {
	int x,y;
	boolean marked;
	boolean used;
	
	/**
	 * Constructs an AbstractTileContainer at column x and row y
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public AbstractTileContainer(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Checks if the other tile is adjacent to this tile.
	 * Tiles are adjacent if they next to each other horizontally or vertically
	 * @param other	the other tile
	 * @return true if the tiles are adjacent, false otherwise
	 */
	public boolean isAdjacentTo(AbstractTileContainer other) {
		if(this.x == other.getX()) {
			if(this.y == other.getY() + 1 || this.y == other.getY() - 1) {
				return true;
			}
		}
		if(this.y == other.getY()) {
			if(this.x == other.getX() + 1 || this.x == other.getX() - 1) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * returns this TileContainers x coordinate
	 * @return this TileContainers x coorditane
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * returns this TileContainers y coordinate
	 * @return this TileContainers y coorditane
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * A tile being marked means it counts towards the completion goal on elimination levels
	 * @return true if the tile is marked, false otherwise
	 */
	public boolean marked() {
		return marked;
	}

	/**
	 * sets marked to true
	 */
	public void mark() {
		this.marked = true;
	}
	
	/**
	 * A tile being used means it is involved in a move, and should
	 * be drawn differently in the BoardView
	 * @return	true if the tile is being used, false otherwise
	 */
	public boolean used() {
		return used;
	}
	
	/**
	 * Set the used variable
	 * when adding a tile to a move, this should be set with true
	 * when finishing a move, this should be set to false
	 * @param used	whether or not the tile is being used in a move
	 */
	public void setUsed(boolean used) {
		this.used = used;
	}

	/**
	 * For buckets, null tiles, clearing means  nothing, and nothing happens
	 * NumberTileContainers override this
	 */
	public void clearTile() {}
	
	public abstract boolean isNull();
	public abstract boolean empty();
	public abstract boolean addTile(Tile t);
	public abstract Tile getTile();

}
