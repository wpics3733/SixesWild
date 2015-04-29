package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.LevelView;
import model.Level;
import model.RearrangeMove;

public class RearrangeBoardController implements MouseListener {
	Level l;
	LevelView lv;
	
	public RearrangeBoardController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(l.hasSpecial(Level.REARRANGE)) {
		RearrangeMove move = new RearrangeMove();
		move.pushMove(l);
		if(l.isFinished()) {
			lv.endLevel();
			return;
		}
		lv.repaint();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
