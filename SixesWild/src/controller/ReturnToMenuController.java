package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Application;
import view.MainMenuView;
import view.PastLevelPanel;

public class ReturnToMenuController implements MouseListener {
	
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