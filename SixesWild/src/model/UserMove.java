package model;

import java.util.ArrayList;
import java.util.Iterator;

public class UserMove implements IMove, Iterable<AbstractTileContainer> {
	ArrayList<AbstractTileContainer> tiles;
	int sum;
	int multiplier;
	int numTiles;

	public UserMove() {
		sum = 0;
		multiplier = 1;
		numTiles = 0;
		tiles = new ArrayList<AbstractTileContainer>();
	}

	@Override
	public boolean addTile(AbstractTileContainer tc) {
		if(tiles.contains(tc)) {
			return false;
		}
		if(tiles.isEmpty()) {
			addAcceptedTile(tc);
			return true;
		}

		for(AbstractTileContainer i: tiles) {
			if(i.isAdjacentTo(tc)) {
				addAcceptedTile(tc);
				return true;
			}
		}
		return false;
	}

	private void addAcceptedTile(AbstractTileContainer tc) {
		tc.setUsed(true);
		tiles.add(tc);
		sum += tc.getTile().getNum();
		multiplier *= tc.getTile().getMultiplier();
		numTiles++;

	}

	public int getScore() {
		if(this.isValid()) {
			return 10*numTiles * multiplier;
		} else {
			return 0;
		}		
	}


	@Override
	public boolean isValid() {
		return sum == 6 && numTiles > 1;
	}

	/**
	 * When a valid move is done, this method is called
	 * in order to push that move to the level
	 */
	@Override
	public void pushMove(Level l) {
		for(AbstractTileContainer tc: tiles) {
			tc.clearTile();
		}
		l.getBoard().settleTiles();
		l.setScore(l.getScore() + this.getScore());
	}

	/**
	 * After any move, valid or invalid,
	 * this method should be called, to reset the markings
	 * on the tiles, and apply any logic that takes
	 * place after either a successful or failed move
	 * eg. subtract a move
	 */
	public void finishMove(Level l) {
		for(AbstractTileContainer tc: tiles) {
			tc.setUsed(false);
		}
		
		// check to see if this move has unlocked any achievements
		OnMoveAchievement.checkAll(this);
	}

	@Override
	public ArrayList<AbstractTileContainer> getTiles() {
		return tiles;
	}

	@Override
	public Iterator<AbstractTileContainer> iterator() {
		return tiles.iterator();
	}
}
