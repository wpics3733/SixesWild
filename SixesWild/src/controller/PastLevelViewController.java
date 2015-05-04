package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Application;
import view.PastLevelPanel;

/**
 * This controller is bound to the "Levels" button in the main menu
 * When pressed, it takes the user to a view where they can see all of their past levels
 * @author jesse
 *
 */
public class PastLevelViewController implements MouseListener {
	private Application parent;
	

	public PastLevelViewController(Application parent) {
		this.parent = parent;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		parent.changeView(new PastLevelPanel(parent));
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

}