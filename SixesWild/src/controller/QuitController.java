package controller;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import view.Application;

/**
 * The controller to quit out of the application
 * @author jesse
 *
 */
public class QuitController implements MouseInputListener {
	Application a;
	
	public QuitController(Application a) {
		this.a = a;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		a.setVisible(false);
		a.dispose();
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
