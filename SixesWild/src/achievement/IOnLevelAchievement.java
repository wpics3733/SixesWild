package achievement;

import model.Level;

/**
 * Acheivements that are calculated after the completion of a level.
 * @author justin
 *
 */
public abstract class IOnLevelAchievement extends Achievement {
	/** 
	 * Contructor for subclasses.
	 */
	protected IOnLevelAchievement() { super(); }
	
	/**
	 * Each Achievement knows whether or not is has been satisfied.
	 * <p>
	 * Required that the Achievement sets this.unlocked = true if true.
	 * @param level the level being checked
	 * @return boolean
	 */
	public abstract boolean unlocked(Level level);
}
