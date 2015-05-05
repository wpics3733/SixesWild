package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MouseInputListener;

import view.Application;

/**
 * The controller to quit out of the application
 * @author jesse
 *
 */
public class QuitController extends MouseAdapter {
	Application a;
	
	/**
	 * Construct a new QuitController to close the Application frame a
	 * @param a	the application frame to close
	 */
	public QuitController(Application a) {
		this.a = a;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		a.setVisible(false);
		a.dispose();
	}

}
