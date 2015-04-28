package achievement;

import model.IMove;

/**
 * Acheivements that are calculated after each move is made.
 * @author justin
 *
 */
public abstract class OnMoveAchievement extends Achievement {
	/** 
	 * Contructor for subclasses.
	 */
	protected OnMoveAchievement() { super(); }
	
	/**
	 * Each Achievement knows whether or not is has been satisfied.
	 * <p>
	 * Required that the Achievement sets this.unlocked = true if true.
	 * @param move the move being checked
	 * @return boolean
	 */
	public abstract boolean unlocked(IMove move);
}
