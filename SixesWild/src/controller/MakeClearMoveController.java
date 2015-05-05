package controller;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MouseInputListener;

import view.BoardPanel;
import view.LevelView;
import view.TilePanel;
import model.ClearMove;
import model.Level;
import model.SwapMove;

/**
 * This is the controller bound to the board during a clear move.
 * Whenever a tile is clicked, it clears the number, settles the board,
 * then switches the controller back to the standard UserMove controller
 * @author jesse
 *
 */
public class MakeClearMoveController extends MouseAdapter {
	Level l;
	LevelView lv;
	BoardPanel bp;
	ClearMove move;
	int tiles_selected;
	
	/**
	 * Make a new MakeClearMoveController
	 * @param l		The level the user is playing
	 * @param lv	The LevelView associated with l
	 */
	public MakeClearMoveController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
		this.bp = lv.getBoard();
		this.move = new ClearMove();
		tiles_selected = 0;
		
	}

	/**
	 * Try to add the tilePanel under the mouse to a new clearMove. If the tile
	 * added successfully, the move should be valid and run
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Component c = bp.getComponentAt(arg0.getPoint());
		if(c instanceof TilePanel) {
			move.addTile( ((TilePanel)c).getTile());
			if(move.isValid()) {
				move.pushMove(l);
			}
			if(l.isFinished()) {
				lv.endLevel();
				return;
			}
			lv.repaint();
			lv.changeController(new MakeUserMoveController(l, lv));
		} 
	}

}
