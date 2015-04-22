package model;

public class Board {
	TileContainer tiles[][];
	int h;
	int w;
	int tile_ratios[];
	int tile_ratio_sum;
	
	public Board(int w, int h) {
		
		this.h = h;
		this.w = w;
		tile_ratios = new int[6];
		for( int i = 0; i < 6; i++) {
			tile_ratios[i] = 1;
			tile_ratio_sum += tile_ratios[i];
		}
		tiles = new TileContainer[w][h];
		for( int i = 0; i < w; i++) {
			for( int j = 0; j < h; j++) {
				
				tiles[i][j] = new TileContainer(this.getRandomTile(), i, j);
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
	
	public Tile getRandomTile() {
		int rand = (int)(Math.random() * tile_ratio_sum) + 1;
		for(int i = 0; i < 6; i++) {
			if(rand <= tile_ratios[i]) {
				return new Tile(i + 1, 1);
			}
			rand -= tile_ratios[i];
		}
		return new Tile(-1, 1);
	}
	
	public void settleTiles() {
		for(int i = 0; i < w; i++) {
			settleCol(i);
		}
		
	}
	
	private void settleCol(int which_col) {
		TileContainer[] col = tiles[which_col];
		for(int i = h - 1; i >= 0; i--) {
			if(col[i].empty) {
				dropTile(which_col, i, i-1);
			}
		}
	}
	
	private void dropTile(int col, int drop_dest, int drop_source) {
		if(drop_source < 0) {
			tiles[col][drop_dest].setTile(this.getRandomTile());
			return;
		}
		
		if(tiles[col][drop_source].empty() == false) {
			tiles[col][drop_dest].setTile(tiles[col][drop_source].getTile());
			tiles[col][drop_source].clearTile();
			return;
		}
		
		dropTile(col, drop_dest, drop_source - 1);
		
	}
}
