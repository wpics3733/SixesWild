package model;

import java.util.ArrayList;
import java.util.Iterator;

public class UserMove implements Iterable<TileContainer> {
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
	
	public int getSum() {
		return sum;
	}
	
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
	
	public boolean isValid() {
		return sum == 6;
	}

	public void clearTiles() {

		for(TileContainer tc: tiles) {
			tc.setMarked(false);
			if(isValid()) {
				int tileNum = (int)(Math.random() * 5) + 1;
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
