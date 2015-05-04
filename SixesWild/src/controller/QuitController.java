package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MouseInputListener;

import view.Application;

/**
 * The controller to quit out of the application
 * @author jesse
 *
 */
public class QuitController implements MouseListener {
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
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
