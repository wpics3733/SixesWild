package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;

import controller.PlayPastLevelController;
import model.Level;

/**
 * The pastLevelPanel contains one of these buttons for each level
 * if the level is unlocked, it shows the level name and type.
 * If the level is locked, it simply shows a "Locked" message
 * Attached to this button is a controller that takes you to the screen where you can start playing
 * @author jesse
 *
 */
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
	
	/**
	 * Set the PlayPastLevelController associated with this button
	 */
	public void setController(PlayPastLevelController controller) {
		this.controller = controller;
		this.addMouseListener(controller);
	}
	
	/**
	 * Return the controller associated with this button, used by the reset progress button
	 * in order to remove the controller
	 * @return the controller associated with this button
	 */
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
			this.setBackground(new Color(200, 200, 0));
			name.setText("locked");
			this.setEnabled(false);
		}
		
	}

}
