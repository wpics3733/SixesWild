package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import view.Application;
import view.PastLevelButton;
import view.PastLevelPanel;
import model.Level;
import model.LevelState;

public class ResetProgressController implements MouseListener {
	
	ArrayList<Level> levels;
	PastLevelPanel view;
	ArrayList<PastLevelButton> buttons;
	Application a;
	
	public ResetProgressController(Application a, ArrayList<Level> levels, PastLevelPanel view, ArrayList<PastLevelButton> buttons) {
		this.buttons = buttons;
		this.levels = levels;
		this.view = view;
		this.a = a;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		for(Level l: levels) {
			LevelState state = l.getLevelState();
			state.setHighScore(0);
			state.setUnlocked(false);
			state.saveState();
		}
		for(PastLevelButton b: buttons) {
			b.removeMouseListener(b.getController());
		}
		levels.get(0).getLevelState().setUnlocked(true);
		buttons.get(0).setController(new PlayPastLevelController(a, levels.get(0), levels.get(1)));
		view.repaint();
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
