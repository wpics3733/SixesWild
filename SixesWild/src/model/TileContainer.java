package model;

public class TileContainer {
	Tile contained;
	int marked;
	public TileContainer(Tile contained) {
		this.contained = contained;
	}
	
	public Tile getTile() {
		return contained;
	}

}
