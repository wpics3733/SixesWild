package model;

import java.util.ArrayList;

public class RearrangeMove implements IMove {

	@Override
	public boolean addTile(AbstractTileContainer tc) {
		return false;
	}

	@Override
	public void pushMove(Level l) {
		Board b = l.getBoard();
		AbstractTileContainer[][] tiles = b.getTileContainers();
		for(int i = 0; i < b.getW(); i++) {
			for(int j = 0; j < b.getH(); j++) {
				if(tiles[i][j] instanceof NumberTileContainer) {
					tiles[i][j].clearTile();
					tiles[i][j].addTile(l.getBoard().getRandomTile());
				}
			}
		}
		l.react(this);
		l.useSpecial(Level.REARRANGE);
	}

	@Override
	public boolean isValid() {
		return true;
	}
	
	public ArrayList<AbstractTileContainer> getTiles() {
		return null;
	}

}
