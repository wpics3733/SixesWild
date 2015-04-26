package controller;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import model.Level;
import view.LevelView;

public class InitiateSwapMoveController implements MouseInputListener {
	
	Level l;
	LevelView lv;
	
	public InitiateSwapMoveController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		lv.changeController((MouseInputListener)new MakeSwapMoveController(l, lv));
		
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
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
