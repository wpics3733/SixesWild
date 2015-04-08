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
		multiplier = 0;
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
			return numTiles * multiplier;
		} else {
			return 0;
		}		
	}

	@Override
	public Iterator<TileContainer> iterator() {
		return tiles.iterator();
	}


}
