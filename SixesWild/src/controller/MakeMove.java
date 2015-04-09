package controller;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import model.*;
import view.*;
import java.awt.*;

public class MakeMove implements MouseInputListener {
	UserMove um;
	LevelView lv;
	boolean pressed;
	
	public MakeMove(UserMove um, LevelView lv) {
		this.um = um;
		this.lv = lv;	
		pressed = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if( um.isValid()) {
			Level l = lv.getLevel();
			l.setScore(um.getScore() + l.getScore());
		}
		um.clearTiles();
		lv.repaint();

		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		BoardView bv = lv.getBoard();
		TileView tv = (TileView)bv.getComponentAt(e.getX(), e.getY());
		if(um.addTile( tv.getTile() )) {
			tv.getTile().setMarked(true);
			lv.repaint();
		}


		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}