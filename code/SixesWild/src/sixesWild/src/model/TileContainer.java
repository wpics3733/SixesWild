package model;

public class TileContainer {
	Tile t;
	boolean marked;
	
	public TileContainer(Tile t) {
		this.t = t;
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


}
