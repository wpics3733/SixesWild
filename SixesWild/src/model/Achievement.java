package model;

import java.util.HashSet;
import java.util.Set;

import controller.AchievementFileController;

/**
 * System for achievements. Based loosely around the Move classes from SolitairePluginTutorial
 * in that each Achievement will know how to verify itself.
 * @author justin
 *
 */
public abstract class Achievement {
	
	// This is an incrementing ID assigned to each achievement
	public int ID;
	
	// Whether this achievement has been completed already
	protected boolean unlocked = false;
	
	// A secret achievement will not show up in the achievements menu
	protected boolean secret = false;
	
	// The name of the acheivement
	protected String name;
	
	// A short description of the achievement
	protected String description;
	
	// This is the next ID to be assigned to an achievement
	private static int currentID = 0;
	
	// An array of all the created achievements thus far
	private static Set<Achievement> list;
	
	private static Set<Achievement> secretList;
	
	// We want to keep every new Achievement in the list
	public static void addToSet(Achievement a) {
		if(a.secret) { secretList.add(a); }
		else { list.add(a); }
		a.ID = currentID++;
	}
	
	/**
	 * Return the name of the Achievement.
	 * @return String
	 */
	public String getName() { return this.name; }
	
	/**
	 * Return a description of the Achievement.
	 * @return String
	 */
	public String getDescription() { return this.description; }
	
	/**
	 * Return whether this achievement has been unlocked
	 * @return boolean
	 */
	public boolean isUnlocked() { return this.unlocked; }
	
	/**
	 * Return an iterable of the list of achievements
	 * @return HashSet
	 */
	public static Set<Achievement> getList() {
		return new HashSet<Achievement>(list);
	}
	
	/**
	 * Return an iterable of the secret list
	 * @return HashSet
	 */
	public static Set<Achievement> getSecretList() {
		return new HashSet<Achievement>(secretList);
	}
	
	/**
	 * Finds the acheivement with the given ID and sets is to be unlocked
	 */
	public static void setUnlocked(int ID) {
		for(Achievement a: list) {
			if (a.ID == ID) {
				a.unlocked = true;
				return;
			}
		}
		
		for(Achievement a: secretList) {
			if (a.ID == ID) {
				a.unlocked = true;
				return;
			}
		}
	}
	
	/**
	 * Instantiate all the achievements then load the save file
	 */
	public static void initializeAll() {
		list = new HashSet<Achievement>();
		secretList = new HashSet<Achievement>();
		LoadedAchievement la = new LoadedAchievement();
		OverachieverMoveAchievement oa = new OverachieverMoveAchievement();
		SixTilesMoveAchievement sta = new SixTilesMoveAchievement();
		TwoBadMovesAchievement tbma = new TwoBadMovesAchievement();
		BeatALevelAchievement bala = new BeatALevelAchievement();
		ThreeStarsLevelAchievement tsla = new ThreeStarsLevelAchievement();
		AchievementFileController.loadSave();
	}
}
