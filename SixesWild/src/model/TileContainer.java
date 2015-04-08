package model;

public class TileContainer {
	Tile contained;
	boolean marked;
	public TileContainer(Tile contained) {
		this.contained = contained;
	}
	
	public Tile getTile() {
		return contained;
	}
	
	public boolean getMarked() {
		return marked;
	}
	
	public void setMarked(boolean marked) {
		this.marked = marked;
	}


}
