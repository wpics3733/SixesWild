package entityPackage;

/**
 * Used to modify tiles.  Moves can be undone.
 * @author Dean Kiourtsis
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
	
	/**
	 * Executes the move in levelModel
	 * @param levelModel
	 */
	public void doMove(LevelModel levelModel){
		levelModel.setTileModifier(modifier);
		levelModel.modifyTile(targetCol, targetRow);
	}
	
	/**
	 * Undoes the move in levelModel.
	 * @param levelModel
	 */
	public void undoMove(LevelModel levelModel){
		levelModel.setTile(targetCol, targetRow, previousTile.getCopy());
	}

	/**
	 * @param col
	 * @param row
	 */
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
	
	/**
	 * Returns another ModifyTileMove with the same attributes.
	 * @return ModifyTileMove
	 */
	public ModifyTileMove getCopy(){
		ModifyTileMove tmp = new ModifyTileMove(this.model, this.modifier);
		tmp.setLocation(targetCol, targetRow);
		tmp.setPreviousTile(previousTile.getCopy());
		return tmp;
	}
}
