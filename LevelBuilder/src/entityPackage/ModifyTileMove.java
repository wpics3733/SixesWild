package entityPackage;

/**
 * Used to modify tiles.  Moves can be undone.
 * @author Dean Kiourtsis
 */
public class ModifyTileMove {
	
	/** A reference to the model. */
	protected LevelModel model;
	
	/** The current tile modifier. */
	protected ITileModifier modifier;
	
	/** The column and row of the target tile. */
	protected int targetCol, targetRow;
	protected Tile previousTile;
	
	/**
	 * The constructor to modify a tile move 
	 * @param model a reference to the model.
	 * @param modifier the current tile modifier.
	 * 
	 * @author Dean
	 */
	public ModifyTileMove(LevelModel model, ITileModifier modifier) {
		this.model = model;
		this.modifier = modifier;
	}
	
	/**
	 * Executes the move in levelModel
	 * @param levelModel the model in which the move should be performed.
	 * 
	 * @author Dean
	 */
	public void doMove(LevelModel levelModel){
		levelModel.setTileModifier(modifier);
		levelModel.modifyTile(targetCol, targetRow);
	}
	
	/**
	 * Undoes the move in levelModel.
	 * @param levelModel the model in which the move should be undone.
	 * 
	 * @author Dean
	 */
	public void undoMove(LevelModel levelModel){
		levelModel.setTile(targetCol, targetRow, previousTile.getCopy());
	}

	/**
	 * Sets the target tile location.
	 * 
	 * @param col the column number of a tile
	 * @param row the row number of a tile
	 * 
	 * @author Dean
	 */
	public void setLocation(int col, int row) {
		this.targetCol = col;
		this.targetRow = row;
	}

	/**
	 * Sets the previous tile.
	 * @param t the previous tile.
	 * 
	 * @author Dean
	 */
	public void setPreviousTile(Tile t){
		this.previousTile = t;
	}
	
	/**
	 * Returns another ModifyTileMove with the same attributes.
	 * @return ModifyTileMove a new copy of the this class.
	 * 
	 * @author Dean
	 */
	public ModifyTileMove getCopy(){
		ModifyTileMove tmp = new ModifyTileMove(this.model, this.modifier);
		tmp.setLocation(targetCol, targetRow);
		tmp.setPreviousTile(previousTile.getCopy());
		return tmp;
	}
}
