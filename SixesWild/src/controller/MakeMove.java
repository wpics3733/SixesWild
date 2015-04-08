package controller;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import model.*;
import view.*;
import java.awt.*;

public class MakeMove implements MouseInputListener {
	UserMove um;
	BoardView bv;
	boolean pressed;
	
	public MakeMove(UserMove um, BoardView bv) {
		this.um = um;
		this.bv = bv;	
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
		for(TileContainer tc: um) {
			tc.setMarked(false);

		}
		bv.repaint();
		um = new UserMove();
		
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		TileView tv = (TileView)bv.getComponentAt(e.getX(), e.getY());
		if(um.addTile( tv.getTile() )) {
			tv.getTile().setMarked(true);
			bv.repaint();
		}


		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}