package entityPackage;

/**
 * Used to modify a tile's mark
 * @author Dean Kiourtsis
 */
public class MarkModifier implements ITileModifier {

	/** Indicates whether a tile is marked. */
	int mark;
	
	/**
	 * Constructor for a mark modifier.
	 * @param mark indicates whether the tile should be marked
	 */
	MarkModifier(int mark) {
		this.mark = mark;
	}

	@Override
	/**
	 * Sets the mark for a tile
	 * 
	 * @param tile the tile that is being changed.
	 */
	public void modifyTile(Tile tile) {
		tile.setMark(mark);
	}
	
}
