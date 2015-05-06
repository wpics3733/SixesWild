package model;

/**
 * A secret achievement for playing the test level
 * @author justin
 *
 */
public class TestLevelAchievement extends IOnLevelAchievement {
	
	public TestLevelAchievement() {
		this.name = "Wait...what?";
		this.description = "You weren't supposed to be able to play the test level...";
		this.unlocked = false;
		this.secret = true;
		IOnLevelAchievement.addToSet(this);
	}

	@Override
	public boolean unlocked(Level level) {
		return level.getLevelState().getLevelName().equals("testLevel");
	}
}
