package model;

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
		}
		if(tiles.isEmpty()) {
			addAcceptedTile(tc);
			return true;
		}

		for(TileContainer i: tiles) {
			if(i.isAdjacentTo(tc)) {
				addAcceptedTile(tc);
				return true;
			}
		}
		return false;
	}

	private void addAcceptedTile(TileContainer tc) {
		tc.setUsed(true);
		tiles.add(tc);
		sum += tc.getTile().getNum();
		multiplier *= tc.getTile().getMultiplier();
		numTiles++;

	}

	private int getScore() {
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
		return sum == 6 && numTiles > 1;
	}

	@Override
	public void pushMove(Level l) {
		for(TileContainer tc: tiles) {
			tc.clearTile();
		}
		l.react(this);
		l.setScore(l.getScore() + this.getScore());
	}
	public void finishMove(Level l) {
		l.subtractMove();
		for(TileContainer tc: tiles) {
			tc.setUsed(false);
			tc.clearTile();
		}
	}

	@Override
	public ArrayList<TileContainer> getTiles() {
		return tiles;
	}
}
