package controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.BoardPanel;
import view.LevelView;
import view.TilePanel;
import model.ClearMove;
import model.Level;
import model.SwapMove;

public class MakeClearMoveController implements MouseListener {
	Level l;
	LevelView lv;
	BoardPanel bp;
	ClearMove move;
	int tiles_selected;
	
	public MakeClearMoveController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
		this.bp = lv.getBoard();
		this.move = new ClearMove();
		tiles_selected = 0;
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		Component c = bp.getComponentAt(arg0.getPoint());
		if(c instanceof TilePanel) {
			move.addTile( ((TilePanel)c).getTile() );
			tiles_selected++;
			if(tiles_selected == 1) {
				move.pushMove(l);
				lv.repaint();
				this.move = new ClearMove();
				tiles_selected = 0;
			}
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
