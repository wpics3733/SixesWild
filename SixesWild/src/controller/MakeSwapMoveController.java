package controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

import view.BoardPanel;
import view.LevelView;
import view.TilePanel;
import model.Level;
import model.SwapMove;

public class MakeSwapMoveController implements MouseInputListener {
	Level l;
	LevelView lv;
	BoardPanel bp;
	SwapMove move;
	int tiles_selected;

	public MakeSwapMoveController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
		this.bp = lv.getBoard();
		this.move = new SwapMove();
		tiles_selected = 0;

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		Component c = bp.getComponentAt(arg0.getPoint());
		if(c instanceof TilePanel) {
			if(move.addTile( ((TilePanel)c).getTile() )) {
				((TilePanel)c).repaint();
				tiles_selected++;
				if(tiles_selected == 2) {
					move.pushMove(l);
					lv.repaint();
					this.lv.changeController((MouseInputListener)new MakeUserMoveController(l, lv));
				}
			}
		} 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
