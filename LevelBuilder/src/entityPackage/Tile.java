package entityPackage;

/**
 * Contains logic and information for board tiles.
 * @author Dean Kiourtsis, Tom Finelli
 */
public class Tile {
	
	public static final int BUCKET_TILE = -2;
	public static final int BLOCKED_TILE = -1;
	public static final int RANDOM_TILE = 0;
	
	int x;
	int y;
	int mark;
	int value;
	int multiplier;
	boolean valueIsSet;
	boolean isBlocked;

	/**
	 * Constructor for a Tile.
	 * NOTE:  This constructor should probably be combined with the following constructor.
	 * 
	 * @param x the x coordinate of the tile
	 * @param y the y coordinate of the tile
	 * 
	 * @author Tom Finelli
	 */
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		this.value = 0;
		this.valueIsSet = false;
		// TODO
	}

	/**
	 * Constructs a tile with the given values
	 * @param col
	 * @param row
	 * @param mark
	 * @param value
	 * @param multiplier
	 * @param isBlocked
	 */
	public Tile(int col, int row, int mark, int value, int multiplier, boolean isBlocked) {
		super();
		this.x = col;
		this.y = row;
		this.mark = mark;
		this.value = value;
		this.multiplier = multiplier;
		this.isBlocked = isBlocked;
		if(value < 1){
			this.valueIsSet = false;
		}
	}
	

	/**
	 * Returns a tile's x position
	 * @return
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Returns a tile's y position
	 * @return
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Sets a tile's mark
	 * @param mark
	 */
	public void setMark(int mark) {
		this.mark = mark;
	}

	/**
	 * Sets a tile's value
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
		this.valueIsSet = true;
		this.isBlocked = false;
		if(value == Tile.RANDOM_TILE){
			this.valueIsSet = false;
		}
		else if(value == Tile.BLOCKED_TILE){
			this.isBlocked = true;
			this.setMultiplier(1);
		}
		else if(value == Tile.BUCKET_TILE){
			this.setMultiplier(1);
		}
	}

	/**
	 * Set a tile's multiplier.
	 * Only works if the tile can have a multiplier.
	 * @param multiplier
	 */
	public void setMultiplier(int multiplier) {
		if( !(this.value == Tile.BLOCKED_TILE || this.value == Tile.BUCKET_TILE) ){
			this.multiplier = multiplier;
		}
	}

	/**
	 * Set a tile's blocked status
	 * @param isBlocked
	 */
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	/**
	 * Returns a tile's value
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Returns a tile's multiplier
	 * @return
	 */
	public int getMultiplier() {
		return multiplier;
	}
	
	/**
	 * Return a tile's coordinates in the form "(y, x)"
	 * @return
	 */
	public String getCoordinate() {
		return "(" + ((Integer) this.y).toString() + ", " + ((Integer) this.x).toString() + ")";
	}

	public Tile getCopy() {
		Tile tmp = new Tile(this.x, this.y, this.mark, this.value, this.multiplier, isBlocked);
		return tmp;
	}
	
}
