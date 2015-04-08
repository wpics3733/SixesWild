package model;

public class Tile {
	int num;
	int multiplier;
	public Tile( int num, int multiplier) {
		this.num = num;
		this.multiplier = multiplier;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public int getMultiplier() {
		return multiplier;
	}

}
