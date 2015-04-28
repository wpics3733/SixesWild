package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ReturnToMenuController;

/**
 * 
 * @author justin
 *
 */
public class AchievementPanel extends JPanel {
	private static final long serialVersionUID = 1;

	public AchievementPanel(Application parent) {
		super(new BorderLayout(0, 0));
		
		// Panel for the left side
		JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT,23,12));
		JButton back= new JButton("Back");
		back.addMouseListener(new ReturnToMenuController(parent));
		left.add(back);
		
		// Grid for the achievements
		JPanel grid = new JPanel(new GridLayout(3,5,5,5));
		
		// do things with the grid
		
		this.add(left,BorderLayout.NORTH);
		this.add(grid, BorderLayout.CENTER);
	}
}
