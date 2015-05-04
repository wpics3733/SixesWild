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

/**
 * The controller attached to each Level button in the PastLevelsView
 * clicking on the button takes you to a LevelView for that level
 * @author jesse
 *
 */
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
		if(parent == null) {
			System.out.println("Parent was null");
		}
		if(lv == null) {
			System.out.println("lv was null");
		}
		parent.changeView(lv);
		
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