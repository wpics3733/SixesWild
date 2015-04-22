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
		tiles.add(tc);
		sum += tc.getTile().getNum();
		multiplier *= tc.getTile().getMultiplier();
		numTiles++;

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
		System.out.println("Pushing a user move to the level");
		for(TileContainer tc: tiles) {
			System.out.printf("%d, %d\n", tc.getX(), tc.getY());
		}
		if(this.isValid()) {
			l.setScore(l.getScore() + this.getScore());
			l.subtractMove();
		}
	}
}
