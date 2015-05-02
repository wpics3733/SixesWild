package model;

public class NumberTileContainer extends AbstractTileContainer{

	Tile t;

	public NumberTileContainer(Tile t, int x, int y) {
		super(x, y);
		this.t = t;
	}

	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public boolean empty() {
		if(t == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean addTile(Tile t) {
		if(t == null) {
			throw new NullPointerException();
		}
		if( this.t == null) {
			this.t = t;
			return true;
		}
		return false;
	}
	
	@Override
	public void clearTile() {
		this.t = null;
	}

	@Override
	public Tile getTile() {
		return t;
	}

}
