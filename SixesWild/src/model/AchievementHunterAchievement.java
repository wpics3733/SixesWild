package model;

/**
 * Secret achievement for unlocking every other achievement
 * @author justin
 *
 */
public class AchievementHunterAchievement extends Achievement {
	static AchievementHunterAchievement aha;
	
	public AchievementHunterAchievement() {
		this.name = "Achievement Hunter!";
		this.description = "Unlock every other achievement";
		this.unlocked = false;
		this.secret = true;
		aha = this;
		Achievement.addToSet(this);;
	}
	
	// I don't check secret achievements
	// because: 1. they're secret
	// and 2. this achievement is in the secret list
	// so it would never be true
	public static void check() {
		for (Achievement a : Achievement.getList()) {
			if (!a.isUnlocked()) { return; }
		}
		aha.unlocked = true;
	}

}
