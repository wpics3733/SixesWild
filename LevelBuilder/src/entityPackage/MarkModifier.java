package entityPackage;

/**
 * @author Dean Kiourtsis
 * Used to modify a tile's mark
 */
public class MarkModifier implements ITileModifier {

	int mark;
	
	// constructor
	MarkModifier(int mark) {
		this.mark = mark;
	}

	@Override
	public void modifyTile(Tile tile) {
		tile.setMark(mark);
	}
	
}
