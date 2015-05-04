package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Application;
import view.SplashPanel;

public class ShowCreditController implements MouseListener {
	
	Application app;
	
	public ShowCreditController(Application app) {
		this.app = app;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.app.changeView(new SplashPanel(app));
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