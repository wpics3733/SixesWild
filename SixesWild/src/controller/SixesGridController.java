package controller;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import model.*;
import view.*;
import java.awt.*;

public class SixesGridController implements MouseInputListener {
	SixesGridView sgv;
	SixesGridModel sgm;
	boolean pressed;
	
	public SixesGridController(SixesGridView sgv, SixesGridModel sgm) {
		this.sgv = sgv;
		this.sgm = sgm; 	
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
		System.out.printf("Mouse pressed, creating a new Move\n");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.printf("Mouse released, move is finished\n");
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		TileView tv = (TileView)sgv.getComponentAt(e.getX(), e.getY());
		tv.setBackground(Color.RED);
		sgv.repaint();

		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}