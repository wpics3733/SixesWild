package model;

import java.util.ArrayList;

public class ClearMove implements IMove {
	AbstractTileContainer tile;

	@Override
	public boolean addTile(AbstractTileContainer tc) {
		if(tc.empty() || tc.isNull()) {
			return false;
		}
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
	public ArrayList<AbstractTileContainer> getTiles() {
		ArrayList<AbstractTileContainer> toRet = new ArrayList<AbstractTileContainer>();
		if(tile != null) {
			toRet.add(tile);
		}
		return toRet;
	}

}
