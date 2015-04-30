package entityPackage;

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
	
	// constructor
	public LevelModel() {
		//TODO
		
		this.board = new Tile[9][9];
		
		System.out.println("LevelModel::Initializing the board with tiles");
		System.out.print("LevelModel::The following tiles have been generated: ");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.board[j][i] = new Tile(j, i);
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
	
	

	public LevelModel(LevelState l) {
		this.mode = l.getLevelType();
		this.movesAllowed = l.getMoveLimit();
		this.specialMovesAllowed = l.getSpecialMoves();
		this.timeAllowed = l.getTimeLimit();
		this.multiplierProbabilities = l.getMultiplierProbabilities();
		this.tileProbabilities = l.getTileProbabilities();
		this.levelName = l.getLevelName();
		
		this.board = new Tile[9][9];
		for(int row = 0; row < 9; row++){
			for(int col = 0; col < 9; col++){
				this.board[row][col] = new Tile(l.getMarks()[row][col], l.getBoardVals()[row][col], l.getMultipliers()[row][col], l.getBlockedTiles()[row][col]);
			}
		}
	}
	
	public void saveLevel() {
		int boardNumbers[][] = new int[9][9];
		int boardMarks[][] = new int[9][9];
		int multipliers[][] = new int[9][9];
		boolean blockedTiles[][] = new boolean[9][9];
		for(int row = 0; row < 9; row++){
			for(int col = 0; col < 9; col++){
				boardNumbers[row][col] = board[row][col].value;
				boardMarks[row][col] = board[row][col].mark;
				multipliers[row][col] = board[row][col].multiplier;
				blockedTiles[row][col] = board[row][col].isBlocked;
			}
		}
		LevelState l = new LevelState(levelName, boardNumbers, boardMarks, multipliers, blockedTiles, 9, 9, mode, starMilestones, specialMovesAllowed, timeAllowed, movesAllowed, multiplierProbabilities, tileProbabilities, true, 0);
		l.saveState();
	}
	
	public void setSelectedTile(int x, int y) {
		this.selectedTile = board[x][y];
	}

	public Tile getSelectedTile() {
		return this.selectedTile;
	}
	
	
	
	// Getters for the model's attributes	
	public int[] getStarMilestones() {
		return starMilestones;
	}

	public int getMovesAllowed() {
		return movesAllowed;
	}

	public int[] getSpecialMovesAllowed() {
		return specialMovesAllowed;
	}

	public int getTimeAllowed() {
		return timeAllowed;
	}

	public int[] getMultiplierProbabilities() {
		return multiplierProbabilities;
	}

	public int[] getTileProbabilities() {
		return tileProbabilities;
	}



	// Setters for the model's attributes
	public void setStarMilestones(int one, int two, int three) {
		this.starMilestones[0] = one;
		this.starMilestones[1] = two;
		this.starMilestones[2] = three;
	}

	public void setMovesAllowed(int movesAllowed) {
		this.movesAllowed = movesAllowed;
	}

	public void setSpecialMovesAllowed(int rearrange, int swap, int clear) {
		this.specialMovesAllowed[0] = rearrange;
		this.specialMovesAllowed[1] = swap;
		this.specialMovesAllowed[2] = clear;
	}

	public void setTimeAllowed(int timeAllowed) {
		this.timeAllowed = timeAllowed;
	}

	public void setMultiplierProbabilities(int one, int two, int three) {
		this.multiplierProbabilities[0] = one;
		this.multiplierProbabilities[1] = two;
		this.multiplierProbabilities[2] = three;
	}

	public void setTileProbabilities(int one, int two, int three, int four, int five, int six) {
		this.tileProbabilities[0] = one;
		this.tileProbabilities[1] = two;
		this.tileProbabilities[2] = three;
		this.tileProbabilities[3] = four;
		this.tileProbabilities[4] = five;
		this.tileProbabilities[5] = six;

	}
	
	public void modifyTile(int col, int row){
		if(this.selectedModifier == null){
			return;
		}
		this.selectedModifier.modifyTile(board[col][row]);
		System.out.println(board[col][row].value);
	}

	public void setTileModifier(ITileModifier itm) {
		this.selectedModifier = itm;
	}

}
