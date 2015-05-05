package controller;

import java.awt.event.MouseAdapter;
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
public class PastLevelViewController extends MouseAdapter {
	private Application parent;
	

	/**
	 * Construct a new PastLevelView controller under the given ApplicationFrame
	 * @param parent	The top level Application frame
	 */
	public PastLevelViewController(Application parent) {
		this.parent = parent;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		parent.changeView(new PastLevelPanel(parent));
		// TODO Auto-generated method stub
		
	}
}