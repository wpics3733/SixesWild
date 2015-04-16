package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Level;
import view.Application;
import view.LevelView;

public class PlayPastLevelController implements MouseListener {
	Application parent;
	Level toPlay;
	
	public PlayPastLevelController(Application parent, Level toPlay) {
		this.parent = parent;
		this.toPlay = toPlay;
		
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		LevelView lv = new LevelView(toPlay, parent);
		parent.changeView(lv);
		
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
