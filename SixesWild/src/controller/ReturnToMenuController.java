package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.Application;
import view.MainMenuView;

/**
 * When activated, this controller returns the User to the main menu
 * by changing the active panel in the application frame to a new menu
 * @author jesse
 *
 */
public class ReturnToMenuController extends MouseAdapter {
	
	private Application parent;
	
	/**
	 * Construct a new ReturnToMenuController for the given Application
	 * @param parent
	 */
	public ReturnToMenuController(Application parent) {
		this.parent = parent;
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		parent.changeView(new MainMenuView(parent));
		// TODO Auto-generated method stub
		
	}

}