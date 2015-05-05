package entityPackage;

/**
 * Used to modify a tile's mark
 * @author Dean Kiourtsis
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
