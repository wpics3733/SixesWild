package model;

public class TileContainer {
	Tile t;
	int x,y;
	boolean marked;
	
	public TileContainer(Tile t, int x, int y) {
		this.t = t;
		this.x = x;
		this.y = y;
	}
	
	public Tile getTile() {
		return t;
	}
	
	public boolean getMarked() {
		return marked;
	}
	
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	
	public void setTile(Tile t) {
		this.t = t;
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


}
