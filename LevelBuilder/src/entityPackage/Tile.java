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
		this.value = 0;
		this.valueIsSet = false;
		// TODO
	}

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
	

	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public void setValue(int value) {
		this.value = value;
		this.valueIsSet = true;
		if(value == 0){
			this.valueIsSet = false;
		}
		else if(value == -1){
			this.isBlocked = true;
		}
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
		this.isBlocked = false;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public int getValue() {
		return value;
	}

	public int getMultiplier() {
		return multiplier;
	}
	
	public String getCoordinate() {
		return "(" + ((Integer) this.y).toString() + ", " + ((Integer) this.x).toString() + ")";
	}
	
}
