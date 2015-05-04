package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.EliminationLevel;
import model.Level;
import model.LightningLevel;
import model.PuzzleLevel;
import model.ReleaseLevel;
import view.Application;
import view.LevelView;

public class PlayPastLevelController implements MouseListener {
	Application parent;
	Level toPlay, next;
	
	public PlayPastLevelController(Application parent, Level toPlay, Level next) {
		this.parent = parent;
		this.toPlay = toPlay;
		this.next = next;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		LevelView lv;
		if(toPlay instanceof PuzzleLevel) {
			lv = new LevelView((PuzzleLevel)toPlay, next, parent);
		} else if (toPlay instanceof EliminationLevel) {
			lv = new LevelView((EliminationLevel)toPlay, next, parent);
		} else if (toPlay instanceof ReleaseLevel) {
			lv = new LevelView((ReleaseLevel)toPlay, next, parent);
		} else {
			lv = new LevelView((LightningLevel)toPlay, next, parent);
		}
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
