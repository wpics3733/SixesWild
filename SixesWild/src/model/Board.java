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
	int multiplier_ratios[];
	int multiplier_ratio_sum;

	/**
	 * Construct a new board based off of the given LevelState
	 * the board gets all tile nums in the state
	 * it also reads multiplier and tile probabilities
	 * It then constructs the board appropriately
	 * @param l
	 */
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
		multiplier_ratios = new int[3];
		multiplier_ratios = l.getMultiplierProbabilities();
		for(int i = 0; i < 3; i++) {
			multiplier_ratio_sum += multiplier_ratios[i];
		}
		if( multiplier_ratio_sum == 0) {
			for(int i = 0; i < 3; i++) {
				multiplier_ratios[i] = 1;
			}
			multiplier_ratio_sum = 3;
		}
		tiles = new AbstractTileContainer[w][h];
		for(int i = 0; i < w; i++){
			for(int j = 0; j < h; j++){
				int tileNum = l.getBoardVals()[i][j];
				// TileNum of -1 means that the tile is null
				if(tileNum == -2) {
					tiles[i][j] = new BucketTileContainer(i,j);
				} else if(tileNum == -1) {
					tiles[i][j] = new NullTileContainer(i, j);
					// TileNum of 0 means that the tile was not set explicitly, lets generate one randomly
				} else if(tileNum == 0) {
					tiles[i][j] = new NumberTileContainer(getRandomTile(), i, j);
				} else {
					int multiplier = l.getMultipliers()[i][j];
					tiles[i][j] = new NumberTileContainer(new Tile(tileNum, multiplier), i, j);
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
		return new Tile(get_random_number(), get_random_multiplier());
	}
	
	private int get_random_number() {
		int rand = (int)(Math.random() * tile_ratio_sum) + 1;
		for(int i = 0; i < 6; i++) {
			if(rand <= tile_ratios[i]) {
				return i + 1;
			}
			rand -= tile_ratios[i];
		}
		return -1;
	}
	
	private int get_random_multiplier() {
		int rand = (int)(Math.random() * multiplier_ratio_sum) + 1;
		for(int i = 0; i < 3; i++) {
			if(rand <= multiplier_ratios[i]) {
				return i + 1;
			}
			rand -= multiplier_ratios[i];
		}
		return -1;
		
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
