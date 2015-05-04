package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Application;
import view.MainMenuView;
import view.PastLevelPanel;

/**
 * A very basic controller, when the game starts up, the game shows a splash screen
 * This controller allows you to click the splash screen and be taken to the main menu
 * @author jesse
 *
 */
public class ExitSplashScreen implements MouseListener {
	private Application a;
	public ExitSplashScreen(Application a) {
		this.a = a;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		a.changeView(new MainMenuView(a));
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

}
