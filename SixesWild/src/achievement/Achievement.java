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
	private boolean unlocked = false;
	
	// A secret achievement will not show up in the achievements menu
	private boolean secret = false;
	
	// The name of the acheivement
	private String name;
	
	// A short description of the achievement
	private String description;
	
	// An array of all the created achievements thus far
	private Set<Achievement> list = new HashSet<Achievement>();
	
	private Set<Achievement> secretList = new HashSet<Achievement>();
	
	// We want to keep every new Achievement in the list
	protected Achievement() {
		if(this.secret) { secretList.add(this); }
		else { list.add(this); }
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
	
	public boolean unlocked() { return this.unlocked == true; }
}
