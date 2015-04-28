package model;

import java.util.ArrayList;

public class ClearMove implements IMove {
	TileContainer tile;

	@Override
	public boolean addTile(TileContainer tc) {
		this.tile = tc;
		return true;
	}

	@Override
	public void pushMove(Level l) {
		tile.clearTile();
		l.useSpecial(Level.CLEAR);
		l.getBoard().settleTiles();
		
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<TileContainer> getTiles() {
		ArrayList<TileContainer> toRet = new ArrayList<TileContainer>();
		toRet.add(tile);
		return toRet;
	}

}
