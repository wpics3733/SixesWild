package model;

/**
 * The model that represents the board.
 * Boards are a w*h grid of TileContainers
 * Boards also keep track of the tile probabilies,
 * and can generate a random tile given these probabilities
 * @author jesse
 *
 */
public class Board {
	AbstractTileContainer tiles[][];
	int h;
	int w;
	int tile_ratios[];
	int tile_ratio_sum;

	public Board(LevelState l) {
		this.h = l.getHeight();
		this.w = l.getWidth();
		tile_ratios = new int[6];
		this.tile_ratios = l.getTileProbabilities();
		this.tile_ratio_sum = 0;
		for(int i = 0; i < 6; i++) {
			tile_ratio_sum += tile_ratios[i];
		}
		if( tile_ratio_sum == 0) {
			for(int i = 0; i < 6; i++) {
				tile_ratios[i] = 1;
			}
			tile_ratio_sum = 6;
		}
		tiles = new AbstractTileContainer[w][h];
		for(int i = 0; i < w; i++){
			for(int j = 0; j < h; j++){
				int tileNum = l.getBoardVals()[i][j];
				// TileNum of -1 means that the tile is null
				if(tileNum == -1) {
					tiles[i][j] = new NullTileContainer(i, j);
					// TileNum of 0 means that the tile was not set explicitly, lets generate one randomly
				} else if(tileNum == 0) {
					tiles[i][j] = new NumberTileContainer(getRandomTile(), i, j);
				} else {
					tiles[i][j] = new NumberTileContainer(new Tile(tileNum, 1), i, j);
				}
			}
		}
	}
	/**
	 * @return the height of the board
	 */
	public int getH() {
		return h;
	}

	/**
	 * @return the width of the board
	 */
	public int getW() {
		return w;
	}

	/**
	 * 
	 * @return a two dimensional array of the TileContainers in the board
	 */
	public AbstractTileContainer[][] getTileContainers() {
		return tiles;
	}

	/**
	 * Generates a random tile given the tile probabilities
	 * this is used when a new tile falls from the top of the level
	 * @return a new random tile
	 */
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

	/**
	 * After a move, some tiles may have been used up
	 * or cleared.
	 * Calling this method lets gravity fill these empty
	 * slots by dropping the higher tiles into them.
	 * When a new tile is needed to fall from he top,
	 * the board generates a new random tile to fill the slot
	 * 
	 * After this method is called, no TileContainer should be empty
	 */
	public void settleTiles() {
		for(int i = 0; i < w; i++) {
			settleCol(i);
		}

	}

	private void settleCol(int which_col) {
		AbstractTileContainer[] col = tiles[which_col];
		for(int i = h - 1; i >= 0; i--) {
			if(col[i].empty()) {
				dropTile(which_col, i, i-1);
			}
		}
	}

	private void dropTile(int col, int drop_dest, int drop_source) {
		AbstractTileContainer dest = tiles[col][drop_dest];
		if(drop_source < 0) {
			dest.addTile(this.getRandomTile());
			return;
		} 

		AbstractTileContainer source = tiles[col][drop_source];
		Tile dropped;
		if(source.isNull()) {
			return;
		}
		if(source.empty()) {
			dropTile(col, drop_dest, drop_source - 1);
			return;
		}
		dropped = source.getTile();
		if(dest.addTile(dropped)) {
			source.clearTile();
			return;
		}
	}

}
