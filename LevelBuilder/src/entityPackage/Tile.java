package entityPackage;

public class Tile {
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
		// TODO
	}

	public Tile(int mark, int value, int multiplier, boolean isBlocked) {
		super();
		this.mark = mark;
		this.value = value;
		this.multiplier = multiplier;
		this.isBlocked = isBlocked;
		if(value < 1){
			this.valueIsSet = false;
		}
	}
	

	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
}
