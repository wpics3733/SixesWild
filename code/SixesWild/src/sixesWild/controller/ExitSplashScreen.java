package sixesWild.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sixesWild.view.Application;
import sixesWild.view.PastLevelPanel;

public class ExitSplashScreen implements MouseListener {
	private Application a;
	public ExitSplashScreen(Application a) {
		this.a = a;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		a.changeView(new PastLevelPanel(a));
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
