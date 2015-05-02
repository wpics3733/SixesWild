package model;

public abstract class AbstractTileContainer {
	int x,y;
	boolean marked;
	boolean used;
	
	public AbstractTileContainer(int x, int y) {
		this.x = x;
		this.y = y;
	}

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
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean marked() {
		return marked;
	}

	public void mark() {
		this.marked = true;
	}
	
	public boolean used() {
		return used;
	}
	
	public void setUsed(boolean used) {
		this.used = used;
	}

	public void clearTile() {}
	
	public abstract boolean isNull();
	public abstract boolean empty();
	public abstract boolean addTile(Tile t);
	public abstract Tile getTile();

}
