package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.AchievementPanel;
import view.Application;

public class AchievementPanelController implements MouseListener {
	Application parent;
	
	public AchievementPanelController(Application parent) {
		this.parent = parent;
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		AchievementPanel ap = new AchievementPanel(parent);
		parent.changeView(ap);
		
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
