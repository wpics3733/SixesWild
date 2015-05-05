package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.Application;
import view.MainMenuView;

/**
 * When activated, this controller 
 * @author jesse
 *
 */
public class ReturnToMenuController extends MouseAdapter {
	
	private Application parent;
	
	public ReturnToMenuController(Application parent) {
		this.parent = parent;
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		parent.changeView(new MainMenuView(parent));
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