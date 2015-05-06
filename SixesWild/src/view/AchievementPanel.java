package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Achievement;
import model.AchievementHunterAchievement;
import controller.ResetAchievementsController;
import controller.ReturnToMenuController;

/**
 * 
 * @author justin
 *
 */
public class AchievementPanel extends JPanel {
	private static final long serialVersionUID = 1;
	
	public JButton back;
	public JButton reset;

	public AchievementPanel(Application parent) {
		super(new BorderLayout(0, 0));
		this.setBackground(new Color(249,246,242));
		this.setPreferredSize(new Dimension(1024, 768));
		
		// Panel for the left side
		JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT,23,12));
		back= new JButton("Back");
		back.addMouseListener(new ReturnToMenuController(parent));
		left.add(back);
		
		// Panel for the right side
		JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 23, 12));
		reset = new JButton("Reset Achievements");
		reset.addMouseListener(new ResetAchievementsController(parent));
		right.add(reset);
		
		AchievementHunterAchievement.check();
		
		// Grid for the achievements
		JPanel grid = new JPanel(new GridLayout(5,5,5,5));
		
		Set<Achievement> list = Achievement.getList();
		for (Achievement a: list) {
			JLabel label = new JLabel(a.getName());
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setPreferredSize(new Dimension(80, 80));
			label.setOpaque(true);
			label.setToolTipText(a.getDescription());
			// Unlocked achievements will be lighter
			if (a.isUnlocked()) { label.setBackground(Color.LIGHT_GRAY); }
			else { label.setBackground(new Color(110, 110, 110));; }
			grid.add(label);
		}
		
		// For the secret achievements, they will only show up if they have been unlocked
		Set<Achievement> secretList = Achievement.getSecretList();
		for (Achievement a: secretList) {
			if (a.isUnlocked()) {
				JLabel label = new JLabel(a.getName());
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setPreferredSize(new Dimension(80, 80));
				label.setOpaque(true);
				label.setBackground(Color.LIGHT_GRAY);
				label.setToolTipText(a.getDescription());
				grid.add(label);
			}
		}
		
		// Just for testing
		for (int i=1; i<25; i++) {
			JLabel label2 = new JLabel("test" + i);
			label2.setHorizontalAlignment(SwingConstants.CENTER);
			label2.setPreferredSize(new Dimension(80, 80));
			label2.setOpaque(true);
			label2.setBackground(new Color(110, 110, 110));
			grid.add(label2);
		}
		
		JPanel gridContainer = new JPanel(new FlowLayout());
		gridContainer.add(grid);
		
		this.add(left, BorderLayout.WEST);
		this.add(gridContainer, BorderLayout.CENTER);
		this.add(right, BorderLayout.EAST);
	}
}
