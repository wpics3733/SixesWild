package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.Application;
import view.SplashPanel;

public class ShowCreditController extends MouseAdapter{
	
	Application app;
	
	public ShowCreditController(Application app) {
		this.app = app;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.app.changeView(new SplashPanel(app));
	}
	
}
