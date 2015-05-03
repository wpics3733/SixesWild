package entityPackage;

/**
 * @author XOM
 * Used to modify tiles.
 */
public class ModifyTileMove {
	
	protected LevelModel model;
	protected ITileModifier modifier;
	protected int targetCol, targetRow;
	protected Tile previousTile;
	
	public ModifyTileMove(LevelModel model, ITileModifier modifier) {
		this.model = model;
		this.modifier = modifier;
	}
	
	public void doMove(LevelModel levelModel){
		levelModel.setTileModifier(modifier);
		levelModel.modifyTile(targetCol, targetRow);
	}
	
	public void undoMove(LevelModel levelModel){
		levelModel.setTile(targetCol, targetRow, previousTile.getCopy());
	}

	public void setLocation(int col, int row) {
		this.targetCol = col;
		this.targetRow = row;
	}

	/**
	 * Sets the previous tile.
	 * @param t
	 */
	public void setPreviousTile(Tile t){
		this.previousTile = t;
	}
	
	public ModifyTileMove getCopy(){
		ModifyTileMove tmp = new ModifyTileMove(this.model, this.modifier);
		tmp.setLocation(targetCol, targetRow);
		tmp.setPreviousTile(previousTile);
		return tmp;
	}
}
