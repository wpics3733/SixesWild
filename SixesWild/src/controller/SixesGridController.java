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
		pressed = true;
		TileView tv = (TileView)sgv.getComponentAt(e.getX(), e.getY());
		tv.setBackground(Color.RED);
		sgv.repaint();
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		pressed = false;
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {

		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Mouse moved");
		

		// TODO Auto-generated method stub

	}

}
