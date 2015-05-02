package model;

public class TileContainer  {
	Tile t;
	int x,y;
	boolean empty;
	boolean used;
	boolean marked;
	boolean isNull;
	
	public TileContainer(Tile t, int x, int y) {
		if(t == null) {
			this.isNull = true;
		} else {
			this.isNull = false;
		}
		this.t = t;
		this.x = x;
		this.y = y;
		this.empty = false;
		this.marked = false;
	}
	
	public Tile getTile() {
		return t;
	}
	
	public void setTile(Tile t) {
		if( t == null) {
			throw new NullPointerException("error at TileContainer.setTile");
		}
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
		return this.empty;
	}
	
	public void setUsed(boolean used) {
		this.used = used;
	}
	public boolean used() {
		return used;
	}
	
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	
	public boolean getMarked() {
		return marked;
	}
	
	public boolean isNull() {
		return this.isNull;
	}
}
