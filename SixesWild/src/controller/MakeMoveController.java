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

public class MakeMoveController implements MouseInputListener {
	Level l;
	LevelView lv;
	BoardPanel bp;
	boolean pressed;
	
	public MakeMoveController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
		this.bp = lv.getBoard();
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
		this.mouseReleased(arg0);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		IMove move = l.getActiveMove();
		if(move == null) {
			move = new UserMove();
			l.setActiveMove(move);
		}
		Component c = bp.getComponentAt(arg0.getPoint());
		if(c instanceof TilePanel) {
			move.addTile( ((TilePanel)c).getTile() );
		} 
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		IMove move = l.getActiveMove();
		if( move != null) {
			if(move.isValid()) {
				move.pushMove(l);
				l.getBoard().settleTiles();
				lv.repaint();
			}
			l.setActiveMove(null);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		IMove move = l.getActiveMove();
		if(move == null) {
			move = new UserMove();
			l.setActiveMove(move);
		}
		Component c = bp.getComponentAt(arg0.getPoint());
		if(c instanceof TilePanel) {
			move.addTile( ((TilePanel)c).getTile() );
		} 
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

}
