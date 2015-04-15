package sixesWild.model;

import java.util.ArrayList;
import java.util.Iterator;

public class UserMove implements IMove, Iterable<TileContainer> {
	ArrayList<TileContainer> tiles;
	int sum;
	int multiplier;
	int numTiles;
	
	public UserMove() {
		sum = 0;
		multiplier = 1;
		numTiles = 0;
		tiles = new ArrayList<TileContainer>();
	}
	
	@Override
	public boolean addTile(TileContainer tc) {
		if(tiles.contains(tc)) {
			return false;
		} else {
			tiles.add(tc);
			sum += tc.getTile().getNum();
			multiplier *= tc.getTile().getMultiplier();
			numTiles++;
			return true;
		}
	}
	
	@Override
	public int getScore() {
		if (sum == 6) {
			return 10*numTiles * multiplier;
		} else {
			return 0;
		}		
	}

	@Override
	public Iterator<TileContainer> iterator() {
		return tiles.iterator();
	}
	
	@Override
	public boolean isValid() {
		return sum == 6;
	}

	@Override
	public void pushMove(Level l) {

		for(TileContainer tc: tiles) {
			tc.setMarked(false);
			if(isValid()) {
				int tileNum = (int)(Math.random() * 6) + 1;
				tc.setTile(new Tile(tileNum, 1));
				tc.setMarked(false);
			}
		}
		this.tiles = new ArrayList<TileContainer>();

		this.sum = 0;
		this.numTiles = 0;
		this.multiplier = 1;
	}
}
