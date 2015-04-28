package entityPackage;

public class LevelItem {
	int levelNumber;
	String fileName;
	
	public LevelItem (String fileName) {
		// TODO
		this.fileName = fileName;
	}
	
	public LevelModel loadLevel() {
		LevelModel l;
		LevelState state = new LevelState(fileName);
		l = new LevelModel(state);
		return l;
	}

}
