package model;

public class ClearMove implements IMove {
	TileContainer tile;

	@Override
	public boolean addTile(TileContainer tc) {
		this.tile = tc;
		return true;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void pushMove(Level l) {
		tile.clearTile();
		l.getBoard().settleTiles();
		
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

}
