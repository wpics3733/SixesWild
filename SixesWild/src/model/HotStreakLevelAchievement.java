package model;

/**
 * An achievement for finishing three levels in a row with 3 stars
 * @author justin
 *
 */
public class HotStreakLevelAchievement extends IOnLevelAchievement {
	int counter = 0;
	
	public HotStreakLevelAchievement() {
		this.name = "Hot Streak";
		this.description = "Earn three stars in three straight levels";
		this.unlocked = false;
		IOnLevelAchievement.addToSet(this);
	}

	@Override
	public boolean unlocked(Level level) {
		if (level.getScore() > level.getMilestones()[2]) {
			counter++;
		}
		else { counter= 0; }
		return counter == 3;
	}

}
