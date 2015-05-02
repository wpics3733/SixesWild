package model;

/**
 * An achievement for loading the game. Congratulations!
 * @author justin
 *
 */
public class LoadedAchievement extends Achievement {
	
	public LoadedAchievement() {
		this.unlocked = true;
		this.name = "Loaded!";
		this.description = "You Loaded the game!";
		Achievement.addToSet(this);
	}
	
	@Override
	public boolean isUnlocked() {
		return true;
	}
}
