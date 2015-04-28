package entityPackage;

public class Tile {
	int mark;
	int value;
	int multiplier;
	boolean valueIsSet;
	boolean isBlocked;

	public Tile() {
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
	
}
