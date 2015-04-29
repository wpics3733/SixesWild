package achievement;

public class LoadedAchievement extends Achievement {
	
	public LoadedAchievement() {
		this.unlocked = true;
		this.name = "Loaded!";
		this.description = "You Loaded the game!";
		addToSet(this);
	}
}
