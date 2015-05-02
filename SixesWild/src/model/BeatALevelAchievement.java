package model;

/**
 * An achievement for beating your first level!
 * @author justin
 *
 */
public class BeatALevelAchievement extends IOnLevelAchievement {
	
	public BeatALevelAchievement() {
		this.name = "Beat a Level!";
		this.description= "Beat a single level at least once";
		this.unlocked = false;
		IOnLevelAchievement.addToSet(this);
	}

	@Override
	public boolean unlocked(Level level) {
		return level.hasPassed();
	}

}
