package entityPackage;

import java.util.ArrayList;


/**
 * @author Dean Kiourtsis, Tom Finelli
 *
 */
public class LevelModel {
	Tile board[][];
	String mode;
	int starMilestones[]; // size 3
	int movesAllowed;
	int specialMovesAllowed[]; // size 3
	int timeAllowed; // size 0..1
	int multiplierProbabilities[]; // size 3
	int tileProbabilities[]; // size 6
	String levelName;
	int levelNumber;
	ITileModifier selectedModifier;
	Tile selectedTile;
	ArrayList<ModifyTileMove> moves;
	int movePointer;
	ModifyTileMove currentMove;
	
	// constructor
	/**
	 * Constructs a default LevelModel
	 */
	public LevelModel() {
		moves = new ArrayList<ModifyTileMove>();
		movePointer = -1;
		this.board = new Tile[9][9];
		
		System.out.println("LevelModel::Initializing the board with tiles");
		System.out.print("LevelModel::The following tiles have been generated: ");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.board[j][i] = new Tile(j, i, 0, 0, 1, false);
				System.out.print("[" + j + ", " + i + "] ");
			}
		}
		System.out.println();
		
		// Initially, there is no selected tile
		this.selectedTile = null;
		
		// Initialize array sizes for constructor
		this.starMilestones = new int[3];
		this.specialMovesAllowed = new int[3];
		this.multiplierProbabilities = new int[3];
		this.tileProbabilities = new int[6];
		
		
		// Set default values for attributes
		
		// default name
		this.levelName = "default";
		
		
		// mode
		this.mode = "Puzzle";
		
		// starMileStones
		this.starMilestones[0] = 100;
		this.starMilestones[1] = 200;
		this.starMilestones[2] = 300;
		
		// specialMovesAllowed
		for (int i = 0; i < specialMovesAllowed.length; i++) {
			this.specialMovesAllowed[i] = 1;
		}
		
		// multiplierProbabilities
		this.multiplierProbabilities[0] = 70;
		this.multiplierProbabilities[1] = 20;
		this.multiplierProbabilities[2] = 10;
		
		// tileProbabilities
		for (int i = 0; i < this.tileProbabilities.length; i++) {
			tileProbabilities[i] = 15;
		}
		tileProbabilities[0] = 25;
		
		// movesAllowed
		this.movesAllowed = 100;
		
		// timeAllowed
		this.timeAllowed = 100;
		
	}
	
	

	/**
	 * Constructs a LevelModel using a LevelState object
	 * @param l
	 */
	public LevelModel(LevelState l) {
		moves = new ArrayList<ModifyTileMove>();
		movePointer = -1;
		this.mode = l.getLevelType();
		this.movesAllowed = l.getMoveLimit();
		this.specialMovesAllowed = l.getSpecialMoves();
		this.timeAllowed = l.getTimeLimit();
		this.multiplierProbabilities = l.getMultiplierProbabilities();
		this.tileProbabilities = l.getTileProbabilities();
		this.levelName = l.getLevelName();
		this.starMilestones = l.getStarScores();
		
		this.board = new Tile[9][9];
		for(int row = 0; row < 9; row++){
			for(int col = 0; col < 9; col++){
				this.board[col][row] = new Tile(col, row, l.getMarks()[col][row], l.getBoardVals()[col][row], l.getMultipliers()[col][row], l.getBlockedTiles()[col][row]);
			}
		}
	}
	
	/**
	 * Saves the LevelModel to a file using a LevelState object
	 */
	public void saveLevel() {
		int boardNumbers[][] = new int[9][9];
		int boardMarks[][] = new int[9][9];
		int multipliers[][] = new int[9][9];
		boolean blockedTiles[][] = new boolean[9][9];
		for(int col = 0; col < 9; col++){
			for(int row = 0; row < 9; row++){
				boardNumbers[col][row] = board[col][row].value;
				boardMarks[col][row] = board[col][row].mark;
				multipliers[col][row] = board[col][row].multiplier;
				blockedTiles[col][row] = board[col][row].isBlocked;
			}
		}
		LevelState l = new LevelState(levelName, boardNumbers, boardMarks, multipliers, blockedTiles, 9, 9, mode, starMilestones, specialMovesAllowed, timeAllowed, movesAllowed, multiplierProbabilities, tileProbabilities, true, 0);
		l.saveState();
	}
	
	/**
	 * Adds a ModifyTileMove to the stack of moves, and then does the move.
	 * Removes all moves after movePointer from moves array.
	 * @param move
	 */
	public void addMove(int col, int row){
		
		if(col < 0 || col > board.length || row < 0 || row > board[0].length){ // Check bounds
			return;
		}
		if(currentMove == null){
			return;
		}
		currentMove.setLocation(col, row);
		currentMove.setPreviousTile(board[col][row].getCopy());
		
		while(moves.size() > movePointer+1){
			moves.remove(movePointer+1);
		}
		moves.add(currentMove.getCopy());
		doMove();
	}
	
	/**
	 * Does the move at movePointer +1.
	 * Does nothing if there are no more moves.
	 */
	public void doMove(){
		if(moves.size() > movePointer+1){
			movePointer++;
			moves.get(movePointer).doMove(this);
		}
	}
	
	/**
	 * Un-does the move at movePointer.
	 * Does nothing if there are no more moves to undo.
	 */
	public void undoMove(){
		if(movePointer>=0){
			moves.get(movePointer).undoMove(this);
			movePointer--;
		}
	}
	
	/**
	 * Sets a selected tile from the board.
	 * Used to show which tile is being modified.
	 * @param x
	 * @param y
	 */
	public void setSelectedTile(int x, int y) {
		this.selectedTile = board[x][y];
		System.out.println(x + " " + y);
	}

	/**
	 * Returns the currently selected tile
	 * @return
	 */
	public Tile getSelectedTile() {
		return this.selectedTile;
	}
	
	
	
	// Getters for the model's attributes	
	/**
	 * Returns the point milestones for the stars
	 * @return
	 */
	public int[] getStarMilestones() {
		return starMilestones;
	}

	/**
	 * Returns the number of moves allowed in the game
	 * @return
	 */
	public int getMovesAllowed() {
		return movesAllowed;
	}

	/**
	 * Returns the number of special moves allowed in the game
	 * @return
	 */
	public int[] getSpecialMovesAllowed() {
		return specialMovesAllowed;
	}

	/**
	 * Returns the amount of time allowed in the game.
	 * Only affects lightning levels.
	 * @return
	 */
	public int getTimeAllowed() {
		return timeAllowed;
	}

	/**
	 * Returns the probabilities of the X1, X2, and X3 multipliers.
	 * This affects the appearance rate of multipliers in the game.
	 * @return
	 */
	public int[] getMultiplierProbabilities() {
		return multiplierProbabilities;
	}

	/**
	 * Returns the probabilities of the tiles.
	 * This affects the appearance rate of each tile in the game.
	 * @return
	 */
	public int[] getTileProbabilities() {
		return tileProbabilities;
	}
	
	/**
	 * Returns the game mode
	 * @return
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * Returns the tiles in the board
	 * @return
	 */
	public Tile[][] getBoard() {
		return board;
	}



	// Setters for the model's attributes
	/**
	 * Sets the point requirements for each star
	 * @param one
	 * @param two
	 * @param three
	 */
	public void setStarMilestones(int one, int two, int three) {
		this.starMilestones[0] = one;
		this.starMilestones[1] = two;
		this.starMilestones[2] = three;
	}

	/**
	 * Sets the allowed normal moves for a level
	 * @param movesAllowed
	 */
	public void setMovesAllowed(int movesAllowed) {
		this.movesAllowed = movesAllowed;
	}
	
	/**
	 * Returns the number of moves allowed in the game
	 * @return
	 */
	public void setCurrentMove(ModifyTileMove move) {
		this.currentMove = move;
	}

	/**
	 * Sets the number of allowed special moves for a level
	 * @param rearrange
	 * @param swap
	 * @param clear
	 */
	public void setSpecialMovesAllowed(int rearrange, int swap, int clear) {
		this.specialMovesAllowed[0] = rearrange;
		this.specialMovesAllowed[1] = swap;
		this.specialMovesAllowed[2] = clear;
	}

	/**
	 * Sets the time limit for a level.
	 * Only affects lightning levels.
	 * @param timeAllowed
	 */
	public void setTimeAllowed(int timeAllowed) {
		this.timeAllowed = timeAllowed;
	}

	/**
	 * Sets the multiplier appearance rate for a level
	 * @param one
	 * @param two
	 * @param three
	 */
	public void setMultiplierProbabilities(int one, int two, int three) {
		this.multiplierProbabilities[0] = one;
		this.multiplierProbabilities[1] = two;
		this.multiplierProbabilities[2] = three;
	}

	/**
	 * Sets the tile appearance rate for a level
	 * @param one
	 * @param two
	 * @param three
	 * @param four
	 * @param five
	 * @param six
	 */
	public void setTileProbabilities(int one, int two, int three, int four, int five, int six) {
		this.tileProbabilities[0] = one;
		this.tileProbabilities[1] = two;
		this.tileProbabilities[2] = three;
		this.tileProbabilities[3] = four;
		this.tileProbabilities[4] = five;
		this.tileProbabilities[5] = six;

	}
	
	/**
	 * Sets the mode of a level
	 * @param mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * Uses the currently selected modifier to modify the tile at the given location
	 * @param col
	 * @param row
	 */
	public void modifyTile(int col, int row){
		if(this.selectedModifier == null){
			return;
		}
		this.selectedModifier.modifyTile(board[col][row]);
	}

	/**
	 * Sets the tile modifier so that tiles can be modified
	 * @param itm
	 */
	public void setTileModifier(ITileModifier itm) {
		this.selectedModifier = itm;
	}
	
	/**
	 * Returns a tile at the given location on the board
	 * @param col
	 * @param row
	 * @return
	 */
	public Tile getTile(int col, int row){
		if(col < 0 || col > board.length || row < 0 || row > board[0].length){ // Check bounds
			return null;
		}
		return board[col][row];
	}

	/**
	 * Sets the tile at the given location on the board
	 * @param col
	 * @param row
	 * @return
	 */
	public void setTile(int col, int row, Tile t){
		if(col < 0 || col > board.length || row < 0 || row > board[0].length){ // Check bounds
			return;
		}
		board[col][row] = t;
	}


	/**
	 * Sets the name of the level.
	 * Mainly used in loading and saving levels.
	 * @param name
	 */
	public void setName(String name) {
		levelName = name;
	}



	/**
	 * Returns the name of the level
	 * @return
	 */
	public String getName() {
		return levelName;
	}

}
