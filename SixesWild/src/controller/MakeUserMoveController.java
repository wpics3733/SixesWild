package controller;

import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import view.BoardPanel;
import view.LevelView;
import view.TilePanel;
import model.IMove;
import model.Level;
import model.TileContainer;
import model.UserMove;

public class MakeUserMoveController implements MouseInputListener {
	Level l;
	LevelView lv;
	BoardPanel bp;
	UserMove um;

	public MakeUserMoveController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
		this.bp = lv.getBoard();
		this.um = null;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.um = null;
		l.setActiveMove(null);
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		um = new UserMove();
		l.setActiveMove(um);
		Component c = bp.getComponentAt(arg0.getPoint());
		if(c instanceof TilePanel) {
			um.addTile( ((TilePanel)c).getTile() );
		} 
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(this.um == null) {
			throw new RuntimeException("MakeUserMoveController.um was null when mouseReleased was called");
		}
		if(um.isValid()) {
			um.pushMove(l);
			l.getBoard().settleTiles();
			lv.repaint();
		}
		l.setActiveMove(null);
		this.um = null;
	}

@Override
public void mouseDragged(MouseEvent arg0) {
	if(this.um == null) {
		return;
	}
	Component c = bp.getComponentAt(arg0.getPoint());
	if(c instanceof TilePanel) {
		um.addTile( ((TilePanel)c).getTile() );
	} 
	// TODO Auto-generated method stub

}

@Override
public void mouseMoved(MouseEvent arg0) {
}

}
