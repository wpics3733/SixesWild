package achievement;

import java.util.HashSet;
import java.util.Set;

/**
 * System for achievements. Based loosely around the Move classes from SolitairePluginTutorial
 * in that each Achievement will know how to verify itself.
 * @author justin
 *
 */
public abstract class Achievement {
	
	// Whether this achievement has been completed already
	boolean unlocked = false;
	
	// A secret achievement will not show up in the achievements menu
	boolean secret = false;
	
	// The name of the acheivement
	String name;
	
	// A short description of the achievement
	String description;
	
	// An array of all the created achievements thus far
	private static Set<Achievement> list = new HashSet<Achievement>();
	
	private static Set<Achievement> secretList = new HashSet<Achievement>();
	
	// We want to keep every new Achievement in the list
	
	public static void addToSet(Achievement a) {
		if(a.secret) { secretList.add(a); }
		else { list.add(a); }
	}
	
	/**
	 * Return the name of the Achievement.
	 * @return String
	 */
	public String getName() { return this.name; }
	
	/**
	 * Return a description of the Achievment.
	 * @return String
	 */
	public String getDescription() { return this.description; }
	
	/**
	 * Return whether this achievement has been unlocked
	 * @return
	 */
	public boolean isUnlocked() { return this.unlocked; }
	
	/**
	 * Return an iterable of the list of achievements
	 * @return
	 */
	public static Set<Achievement> getList() {
		return new HashSet<Achievement>(list);
	}
	
	/**
	 * Return an iterable of the secret list
	 * @return
	 */
	public static Iterable<Achievement> getSecretList() {
		return new HashSet<Achievement>(secretList);
	}
}
