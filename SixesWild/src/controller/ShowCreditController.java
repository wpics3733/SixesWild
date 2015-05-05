package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Application;
import view.SplashPanel;

/**
 * This controller is bound to the "Credits" button in the main menu
 * When triggered, it shows the user the splash screen
 * 
 * @author jesse
 *
 */
public class ShowCreditController extends MouseAdapter {
	
	Application app;
	
	/**
	 * Constructs a new ShowCreditController for the given Application
	 * @param app	The top levels Application frame
	 */
	public ShowCreditController(Application app) {
		this.app = app;
	}

	/**
	 * Show the Credit screen (the splash panel)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		this.app.changeView(new SplashPanel(app));
	}

}