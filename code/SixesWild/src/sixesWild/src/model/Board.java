package model;

public class Board {
	TileContainer tiles[][];
	int h;
	int w;
	
	public Board(int w, int h) {
		
		this.h = h;
		this.w = w;
		tiles = new TileContainer[w][h];
		for( int i = 0; i < w; i++) {
			for( int j = 0; j < h; j++) {
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
