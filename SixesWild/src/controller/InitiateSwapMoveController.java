package controller;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import model.Level;
import view.LevelView;

/**
 
 * This is the controller attached to the "Swap" button in the top bar
 * When it is pressed, it attaches a SwapMoveController to the game board
 * @author jesse
 
 */
public class InitiateSwapMoveController implements MouseInputListener {
	
	Level l;
	LevelView lv;
	
	public InitiateSwapMoveController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(l.hasSpecial(Level.SWAP)) {
			lv.changeController((MouseInputListener)new MakeSwapMoveController(l, lv));
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
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
