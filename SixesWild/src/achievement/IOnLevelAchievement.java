package achievement;

import java.util.HashSet;
import java.util.Set;

import model.Level;

/**
 * Acheivements that are calculated after the completion of a level.
 * @author justin
 *
 */
public abstract class IOnLevelAchievement extends Achievement {
	
	// A list of all the on level achievments for validation
	private static Set<IOnLevelAchievement> list = new HashSet<IOnLevelAchievement>();
	
	// Add the achievment to this list and to the list of all achievments
	public static void addToSet(IOnLevelAchievement a) {
		list.add(a);
		Achievement.addToSet(a);
	}
	
	/**
	 * Checks all on move achievements that have not yet been unlocked
	 * to see if this move unlocked it
	 * @param move
	 */
	public void checkAllAchievements(Level level) {
		for (IOnLevelAchievement a : list) {
			if (!a.isUnlocked()) {
				if (a.unlocked(level)) { a.unlocked = true; }
			}
		}
	}
	
	/**
	 * Each Achievement knows whether or not is has been satisfied.
	 * <p>
	 * Required that the Achievement sets this.unlocked = true if true.
	 * @param level the level being checked
	 * @return boolean
	 */
	public abstract boolean unlocked(Level level);
}
