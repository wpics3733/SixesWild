package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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
	StarPanel stars;
	PlayPastLevelController controller;
	
	public PastLevelButton(int num) {
		this.setPreferredSize(new Dimension(180, 120));
		this.setLayout(new BorderLayout());
		name = new JLabel(Integer.toString(num));
		name.setFont(new Font("Sans", Font.PLAIN, 20));
		name.setBorder(new EmptyBorder(5,5,5,5));
		this.add(name, BorderLayout.CENTER);
		this.setBackground(Color.LIGHT_GRAY);
		stars = new StarPanel(0, 20);
		stars.setVisible(false);
		stars.setOpaque(false);
		this.add(stars, BorderLayout.SOUTH);
		

		this.setBorder(new LineBorder(Color.BLACK));
		
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
			this.setBackground(new Color(142, 177, 143));
			name.setText("<html>\"" + l.getLevelState().getLevelName() + "\"<br><br>" + l.typeString() + "</html>");
			int starNum = l.starsEarned(l.getLevelState().getHighScore());
			stars.setStars(starNum);
			stars.setVisible(true);
			this.setEnabled(true);
		} else {
			stars.setVisible(false);
			this.setBackground(new Color(112, 147, 113));
			name.setText("locked");
			this.setEnabled(false);
		}
		
	}

}
