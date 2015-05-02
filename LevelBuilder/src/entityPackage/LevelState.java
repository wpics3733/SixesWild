package entityPackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class LevelState {
	protected String levelName;
	
	protected int boardVals[][];
	protected int marks[][];
	protected int multipliers[][];
	protected boolean blockedTiles[][];
	protected int width;
	protected int height;
	
	protected String levelType;
	protected int starScores[];
	protected int specialMoves[];
	protected int timeLimit;
	protected int moveLimit;
	
	protected int multiplierProbabilities[];
	protected int tileProbabilities[];
	
	protected boolean isUnlocked;
	protected int highScore;
	
	public LevelState(String levelName, int[][] boardVals, int[][] marks,
			int[][] multipliers, boolean[][] blockedTiles, int width,
			int height, String levelType, int[] starScores, int[] specialMoves,
			int timeLimit, int moveLimit, int[] multiplierProbabilities,
			int[] tileProbabilities, boolean isUnlocked, int highScore) {
		this.levelName = levelName;
		this.boardVals = boardVals;
		this.marks = marks;
		this.multipliers = multipliers;
		this.blockedTiles = blockedTiles;
		this.width = width;
		this.height = height;
		this.levelType = levelType;
		this.starScores = starScores;
		this.specialMoves = specialMoves;
		this.timeLimit = timeLimit;
		this.moveLimit = moveLimit;
		this.multiplierProbabilities = multiplierProbabilities;
		this.tileProbabilities = tileProbabilities;
		this.isUnlocked = isUnlocked;
		this.highScore = highScore;
	}

	public LevelState() {
		levelName = "defaultLevel";
		
		width = 9;
		height = 9;
		boardVals = new int[width][height];
		marks = new int[width][height];
		multipliers = new int[width][height];
		blockedTiles = new boolean[width][height];
		
		levelType = "Puzzle";
		starScores = new int[3];
		specialMoves = new int[3];
		timeLimit = 0;
		moveLimit = 100;
		
		multiplierProbabilities = new int[3];
		tileProbabilities = new int[6];
		
		isUnlocked = false;
		highScore = 0;
	}
	
	public LevelState(String fileName) {
		this.loadState(fileName);
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelType() {
		return levelType;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	public int[] getStarScores() {
		return starScores;
	}

	public void setStarScores(int[] starScores) {
		this.starScores = starScores;
	}

	public int[] getSpecialMoves() {
		return specialMoves;
	}

	public void setSpecialMoves(int[] specialMoves) {
		this.specialMoves = specialMoves;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public int getMoveLimit() {
		return moveLimit;
	}

	public void setMoveLimit(int moveLimit) {
		this.moveLimit = moveLimit;
	}

	public int[] getMultiplierProbabilities() {
		return multiplierProbabilities;
	}

	public void setMultiplierProbabilities(int[] multiplierProbabilities) {
		this.multiplierProbabilities = multiplierProbabilities;
	}

	public int[] getTileProbabilities() {
		return tileProbabilities;
	}

	public void setTileProbabilities(int[] tileProbabilities) {
		this.tileProbabilities = tileProbabilities;
	}

	public int[][] getBoardVals() {
		return boardVals;
	}

	public void setBoardVals(int[][] boardVals) {
		this.boardVals = boardVals;
	}

	public int[][] getMarks() {
		return marks;
	}

	public void setMarks(int[][] marks) {
		this.marks = marks;
	}

	public int[][] getMultipliers() {
		return multipliers;
	}

	public void setMultipliers(int[][] multipliers) {
		this.multipliers = multipliers;
	}

	public boolean[][] getBlockedTiles() {
		return blockedTiles;
	}

	public void setBlockedTiles(boolean[][] blockedTiles) {
		this.blockedTiles = blockedTiles;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public boolean isUnlocked() {
		return isUnlocked;
	}

	public void setUnlocked(boolean unlocked) {
		this.isUnlocked = unlocked;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
	
	
	
	public void saveState(){
		File f;
		FileOutputStream saveFile;
		ObjectOutputStream save;
		try{// Catch errors in I/O if necessary.
			// Open a file to write to, named SavedObj.sav.
			
			f = new File("Levels/" + levelName.concat(".sav"));
			if(!f.exists()){
				f.createNewFile();
			}
			
			//saveFile=new FileOutputStream(levelName.concat(".sav"));
			saveFile=new FileOutputStream(f);
			
			// Create an ObjectOutputStream to put objects into save file.
			save = new ObjectOutputStream(saveFile);
			
			// Now we do the save.
			//save.writeObject(this);
			
			save.writeObject(this.levelName);
			save.writeObject(this.boardVals);
			save.writeObject(this.marks);
			save.writeObject(this.multipliers);
			save.writeObject(this.blockedTiles);
			save.writeObject(this.width);
			save.writeObject(this.height);
			save.writeObject(this.levelType);
			save.writeObject(this.starScores);
			save.writeObject(this.specialMoves);
			save.writeObject(this.timeLimit);
			save.writeObject(this.moveLimit);
			save.writeObject(this.multiplierProbabilities);
			save.writeObject(this.tileProbabilities);
			save.writeObject(this.isUnlocked);
			save.writeObject(this.highScore);
			
			// Close the file.
			save.close(); // This also closes saveFile.
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	/**
	 * @param fileName
	 * Loads a LevelState object from fileName
	 */
	public void loadState(String fileName){
		File f;
		FileInputStream saveFile;
		ObjectInputStream save;
		try{
			
			f = new File("Levels/" + levelName.concat(".sav"));
			
			
			// Open file to read from, named SavedObj.sav.
			saveFile = new FileInputStream(f);
			
			// Create an ObjectInputStream to get objects from save file.
			save = new ObjectInputStream(saveFile);

			// Now we do the restore.
			// readObject() returns a generic Object, we cast those back
			// into their original class type.
			// For primitive types, use the corresponding reference class.
			//LevelState tmp = (LevelState) save.readObject();
			
			this.levelName = (String) save.readObject();
			this.boardVals = (int[][]) save.readObject();
			this.marks = (int[][]) save.readObject();
			this.multipliers = (int[][]) save.readObject();
			this.blockedTiles = (boolean[][]) save.readObject();
			this.width = (int) save.readObject();
			this.height = (int) save.readObject();
			this.levelType = (String) save.readObject();
			this.starScores = (int[]) save.readObject();
			this.specialMoves = (int[]) save.readObject();
			this.timeLimit = (int) save.readObject();
			this.moveLimit = (int) save.readObject();
			this.multiplierProbabilities = (int[]) save.readObject();
			this.tileProbabilities = (int[]) save.readObject();
			this.isUnlocked = (boolean) save.readObject();
			this.highScore = (int) save.readObject();

			// Close the file.
			save.close(); // This also closes saveFile.
		}
		catch(Exception exc){
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}
}
