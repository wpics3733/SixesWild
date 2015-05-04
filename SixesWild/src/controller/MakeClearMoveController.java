package controller;

import java.awt.Component;
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
 * then switches the controller back to the standard usermove controller
 * @author jesse
 *
 */
public class MakeClearMoveController implements MouseInputListener {
	Level l;
	LevelView lv;
	BoardPanel bp;
	ClearMove move;
	int tiles_selected;
	
	public MakeClearMoveController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
		this.bp = lv.getBoard();
		this.move = new ClearMove();
		tiles_selected = 0;
		
	}

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
			lv.changeController((MouseInputListener)(new MakeUserMoveController(l, lv)));
		} 
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {}

}
