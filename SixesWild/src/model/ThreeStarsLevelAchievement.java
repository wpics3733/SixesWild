package model;

/**
 * An Achievement for beating a level with three stars!
 * @author justin
 *
 */
public class ThreeStarsLevelAchievement extends IOnLevelAchievement {
	
	public ThreeStarsLevelAchievement() {
		this.name = "Three Stars!";
		this.description = "Beat a level with three stars";
		this.unlocked = false;
		IOnLevelAchievement.addToSet(this);
	}

	@Override
	public boolean unlocked(Level level) {
		return level.getScore() > level.getMilestones()[2];
	}
}
