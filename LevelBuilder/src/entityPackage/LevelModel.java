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
		System.out.print("LevelModel::");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.board[j][i] = new Tile(j, i);
				System.out.print("[" + j + ", " + i + "] ");
			}
		}
		System.out.println();
		
		//this.selectedTile = new Tile();
		this.selectedTile = null;
		
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
}
