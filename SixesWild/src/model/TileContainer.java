package model;

public class TileContainer {
	Tile t;
	int x,y;
	boolean empty;
	
	public TileContainer(Tile t, int x, int y) {
		this.t = t;
		this.x = x;
		this.y = y;
		this.empty = false;
	}
	
	public Tile getTile() {
		return t;
	}
	
	public void setTile(Tile t) {
		this.t = t;
		this.empty = false;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public boolean isAdjacentTo(TileContainer other) {
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
	
	public void clearTile() {
		this.empty = true;
	}
	
	public boolean empty() {
		return empty;
	}
	

}
