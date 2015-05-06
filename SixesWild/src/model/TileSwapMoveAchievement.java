package model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * An achievement for swapping two 6 tiles
 * @author justin
 *
 */
public class TileSwapMoveAchievement extends Achievement {
	private static TileSwapMoveAchievement tsma;
	
	public TileSwapMoveAchievement(){
		this.name = "World's Best Move!";
		this.description = "Use a Swap Move to swap two 6 tiles."
					+ " Seriously, why did you do this.";
		this.unlocked = false;
		tsma = this;
		Achievement.addToSet(this);
	}
	
	public static void check(SwapMove move) {
		if (!tsma.isUnlocked()) {
			if (move.tc_1 instanceof NumberTileContainer
					&& move.tc_2 instanceof NumberTileContainer) {
				NumberTileContainer tc1 = (NumberTileContainer) move.tc_1;
				NumberTileContainer tc2 = (NumberTileContainer) move.tc_2;
				if (tc1.getTile().num == 6 && tc2.getTile().num == 6) {
					tsma.unlocked = true;
					JOptionPane.showMessageDialog(new JFrame(), "Achievement Unlocked:" + tsma.getName());
				}
			}
		}
	}

}
