package model;

public class Board {
	TileContainer tiles[][];
	int h;
	int w;
	
	public Board(int h, int w) {
		this.tiles = new TileContainer[h][w];
		this.h = h;
		this.w = w;
		for( int i = 0; i < h; i++) {
			for( int j = 0; j < w; j++) {
				int tileNum = (int)(Math.random() * 6) + 1;
				
				tiles[i][j] = new TileContainer(new Tile(tileNum, 1));
			}
		}
	}
	
	public int getH() {
		return h;
	}
	
	public int getW() {
		return w;
	}
	
	public TileContainer[][] getTiles() {
		return tiles;
	}
}
