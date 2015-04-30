package entityPackage;

public class MarkModifier implements ITileModifier {

	int mark;
	
	// constructor
	MarkModifier(int mark) {
		// TODO
		this.mark = mark;
	}

	@Override
	public void modifyTile(Tile tile) {
		// TODO Auto-generated method stub
		tile.setMark(mark);
	}
	
}
