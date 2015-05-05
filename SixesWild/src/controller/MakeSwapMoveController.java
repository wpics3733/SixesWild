package controller;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import view.BoardPanel;
import view.LevelView;
import view.TilePanel;
import model.Level;
import model.SwapMove;

/**
 * 
 * this is the controller bound to the board whenever the user wants to make a swap move
 * Every time they click on a NumberTilePanel, it tries to add it to the move
 * 
 * After two valid tiles, the move should be valid, and the two will swap positions
 * 
 * @author jesse
 *
 */
public class MakeSwapMoveController extends MouseAdapter {
	Level l;
	LevelView lv;
	BoardPanel bp;
	SwapMove move;

	/**
	 * Construct a new MakeSwapMoveController for the given level, and its associated levelView
	 * @param l		The current level
	 * @param lv	The LevelView associated with l
	 */
	public MakeSwapMoveController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
		this.bp = lv.getBoard();
		this.move = new SwapMove();

	}

	/**
	 * If the JPanel under the mouse is a TilePanel, add it to the SwapMove
	 * If the SwapMove is valid (after two tiles), run the move
	 * After every move, we check if the level is complete
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Component c = bp.getComponentAt(arg0.getPoint());
		if(c instanceof TilePanel) {
			move.addTile( ((TilePanel)c).getTile());
			((TilePanel)c).repaint();
			if(move.isValid()) {
				move.pushMove(l);
				if(l.isFinished()) {
					this.lv.endLevel();
					return;
				}
				lv.repaint();
				lv.changeController(new MakeUserMoveController(l, lv));
			}
		} 
	}
}
