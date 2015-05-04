package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;

import controller.PlayPastLevelController;
import model.Level;

public class PastLevelButton extends JButton {
	private static final long serialVersionUID = 1L;
	Level l;
	JLabel name;
	PlayPastLevelController controller;
	
	public PastLevelButton(int num) {
		this.setPreferredSize(new Dimension(180, 120));
		name = new JLabel(Integer.toString(num));
		this.add(name);
		this.setBackground(Color.LIGHT_GRAY);
	}

	public PastLevelButton(Level l, int num) {
		this(num);
		this.l = l;
	}
	
	public void setController(PlayPastLevelController controller) {
		this.controller = controller;
		this.addMouseListener(controller);
	}
	
	public PlayPastLevelController getController() {
		return controller;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(l == null) {
			name.setText("");
			return;
		}
		if(l.getLevelState().isUnlocked()) {
			this.setBackground(Color.YELLOW);
			name.setText("<html><center> " + l.getLevelState().getLevelName() + "<br>" + l.typeString() + "</center></html>");
			this.setEnabled(true);
		} else {
			this.setBackground(Color.YELLOW);
			name.setText("locked");
			this.setEnabled(false);
		}
		
	}

}
