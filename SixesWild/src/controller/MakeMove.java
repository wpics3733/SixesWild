package controller;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import model.*;
import view.*;
import java.awt.*;

public class MakeMove implements MouseInputListener {
	BoardView bv;
	Board b;
	boolean pressed;
	
	public MakeMove(BoardView bv, Board b) {
		this.bv = bv;
		this.b = b; 	
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
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		TileView tv = (TileView)bv.getComponentAt(e.getX(), e.getY());
		tv.setBackground(Color.RED);
		bv.repaint();

		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}