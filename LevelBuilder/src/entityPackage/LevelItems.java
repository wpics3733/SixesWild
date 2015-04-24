package entityPackage;

public class LevelItems {
	LevelItem levels[]; // size *
	int page;
	String levelDataFilename;
	
	public LevelItems(String levelDataFilename) {
		// TODO
		this.levelDataFilename = levelDataFilename;
	}
	
	public void nextPage() {
		// TODO
	}
	
	public void previousPage() {
		// TODO
	}
	
	public LevelItem getPage() {
		// TODO
		return null; // placeholder
		
		// return levels[page];  <-- possible return statement?
	}
}
