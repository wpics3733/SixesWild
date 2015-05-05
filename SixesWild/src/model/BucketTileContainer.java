package model;

/**
 * Buckets are only used in th "Release" level type.
 * They start out empty and can only be filled by
 * a 6 settling in. Once they are full, they act just like
 * null tiles
 * @author jesse
 *
 */
public class BucketTileContainer extends AbstractTileContainer {
	boolean empty;

	public BucketTileContainer(int x, int y) {
		super(x, y);
		empty = true;
	}

	/**
	 * Checks to see if the Container is empty
	 */
	@Override
	public boolean empty() {
		return empty;
	}

	/**
	 * Tiles are null iff there they are not empty
	 */
	@Override
	public boolean isNull() {
		return !empty;
	}

	/**
	 * Try to add a tile to the Container
	 * Succeeds iff the Tile is a 6
	 * When it succeeds, the Container is no longer empty
	 */
	@Override
	public boolean addTile(Tile t) {
		if(t.getNum() == 6) {
			this.empty = false;
			return true;
		}
		return false;
	}

	/**
	 * This should never be called
	 */
	@Override
	public Tile getTile() {
		return null;
	}

	/**
	 * Since bucket tiles cannot be used in usermoves, they cannot be marked
	 * Since bucket tiles should not appear in elimination levels, there is no harm
	 * in always returning false
	 */
	@Override
	public boolean marked() {
		return false;
	}

}
