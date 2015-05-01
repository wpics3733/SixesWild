package controller;

import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.event.MouseInputListener;

public class ClosePopupController implements MouseInputListener {
	
	JDialog popup;
	
	public ClosePopupController(JDialog popup) {
		this.popup = popup;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		popup.dispose();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
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
