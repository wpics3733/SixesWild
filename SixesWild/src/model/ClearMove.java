package model;

import java.util.ArrayList;

public class ClearMove implements IMove {
	TileContainer tile;

	@Override
	public boolean addTile(TileContainer tc) {
		if(tile == null) {
			this.tile = tc;
			return true;
		}
		return false;
	}

	@Override
	public void pushMove(Level l) {
		tile.clearTile();
		l.useSpecial(Level.CLEAR);
		l.getBoard().settleTiles();
		l.react(this);
		
	}

	@Override
	public boolean isValid() {
		if(this.tile == null) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<TileContainer> getTiles() {
		ArrayList<TileContainer> toRet = new ArrayList<TileContainer>();
		if(tile != null) {
			toRet.add(tile);
		}
		return toRet;
	}

}
