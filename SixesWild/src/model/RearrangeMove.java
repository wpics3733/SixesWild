package model;

import java.util.ArrayList;

/**
 * Rearrange moves clear all non-null, non-empty, non-six tiles on the board
 * and replace them with new randomly generated tiles
 * 
 * Sixes are never replaced because it can make Release levels unwinnable
 * @author jesse
 *
 */
public class RearrangeMove implements IMove {

	/**
	 * Tiles cannot be added to a RearrangeMove, so this always returns false
	 */
	@Override
	public boolean addTile(AbstractTileContainer tc) {
		return false;
	}

	/**
	 * Push the move to the level.
	 * Empty all NumberTileContainers that do not contain 6's
	 * and refill them with a randomly generated Tile
	 * Use up a rearrange special and a move
	 */
	@Override
	public void pushMove(Level l) {
		Board b = l.getBoard();
		AbstractTileContainer[][] tiles = b.getTileContainers();
		for(int i = 0; i < b.getW(); i++) {
			for(int j = 0; j < b.getH(); j++) {
				if(tiles[i][j] instanceof NumberTileContainer) {
					if(tiles[i][j].empty() || tiles[i][j].getTile().getNum() == 6) {
					} else {
						tiles[i][j].clearTile();
						tiles[i][j].addTile(l.getBoard().getRandomTile());
					}
				}
			}
		}
		l.react(this);
		l.useSpecial(Level.REARRANGE);
	}

	/**
	 * Rearrange moves are always valid
	 */
	@Override
	public boolean isValid() {
		return true;
	}
	
	/**
	 * Rearrange moves do not keep track of tiles, so this should never be called
	 * and always returns null
	 */
	public ArrayList<AbstractTileContainer> getTiles() {
		return null;
	}

}
