package model;

public class NullTileContainer extends AbstractTileContainer {
	
	public NullTileContainer(int x, int y) {
		super(x,y);
		this.mark();
	}

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public boolean empty() {
		return false;
	}

	@Override
	public boolean addTile(Tile t) {
		return false;
	}

	@Override
	public Tile getTile() {
		return null;
	}

	@Override
	public void clearTile() {
		
	}

}
