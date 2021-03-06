package model;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Acheivements that are calculated after each move is made.
 * @author justin
 *
 */
public abstract class OnMoveAchievement extends Achievement {
	
	// A list of all the on move achievments for validation
	private static Set<OnMoveAchievement> list = new HashSet<OnMoveAchievement>();
	
	// Add the achievement to this list and the list of all achievements
	protected static void addToSet(OnMoveAchievement a) {
		list.add(a);
		Achievement.addToSet(a);
	}
	
	/**
	 * Checks all on move achievements that have not yet been unlocked
	 * to see if this move unlocked it
	 * @param move
	 */
	public static void checkAll(UserMove move) {
		for (OnMoveAchievement a : list) {
			if (!a.isUnlocked()) {
				if (a.unlocked(move)) {
					a.unlocked = true;
					JOptionPane.showMessageDialog(new JFrame(), "Achievement Unlocked: " + a.getName());
				}
			}
		}
	}
	
	/**
	 * Each Achievement knows whether or not is has been satisfied.
	 * <p>
	 * Required that the Achievement sets this.unlocked = true if true.
	 * @param move the move being checked
	 * @return boolean
	 */
	public abstract boolean unlocked(UserMove move);
}
