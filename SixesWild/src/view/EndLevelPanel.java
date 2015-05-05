package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.RestartLevelController;
import controller.ReturnToMenuController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import model.Level;

/**
 * The panel displayed when the player finishes a level
 * It contains a message declaring whether the player has won or lost,
 * showing the number of stars they earned, and asking if the want to retry or quit to the main menu
 * @author jesse
 *
 */
public class EndLevelPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	JButton quit, restart;
	JLabel winMessage;
	JLabel score_label;
	StarPanel stars;

	/**
	 * Construct a new endLevelPanel for the given Level
	 * If the user chooses to restart, it will replay that level
	 * @param l			The level
	 * @param lv		The view associated with l
	 * @param parent	The top level Application frame
	 */
	public EndLevelPanel(Level l, LevelView lv, Application parent) {
		if(l.hasPassed()) {
			winMessage = new JLabel("You Win");

			int score = l.getScore();
			int m1 = l.getMilestones()[0];
			int m2 = l.getMilestones()[1];
			int m3 = l.getMilestones()[2];
			if( score < m1) {
				stars = new StarPanel(0, 100);
			} else if (score < m2) {
				stars = new StarPanel(1, 100);
			} else if (score < m3) {
				stars = new StarPanel(2, 100);
			} else {
				stars = new StarPanel(3, 100);
			}
		} else {
			winMessage = new JLabel("You lose");
			stars = new StarPanel(0, 100);
		}


		winMessage.setFont(new Font("Sans", Font.PLAIN, 20));
		score_label = new JLabel("Score: " + l.getScore());

		restart = new JButton("Restart");
		restart.addMouseListener(new RestartLevelController(l, lv));

		quit = new JButton("Quit");
		quit.addMouseListener(new ReturnToMenuController(parent));

		GroupLayout gl_contentPanel = new GroupLayout(this);
		gl_contentPanel.setAutoCreateContainerGaps(true);
		gl_contentPanel.setAutoCreateGaps(true);

		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_contentPanel.createSequentialGroup()
						.addContainerGap(0, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.CENTER)
								.addComponent(winMessage)
								.addComponent(score_label)
								.addComponent(stars)
								.addComponent(restart)
								.addComponent(quit))
								.addContainerGap(0, Short.MAX_VALUE))
				);

		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_contentPanel.createSequentialGroup()
						.addComponent(winMessage)
						.addComponent(score_label)
						.addComponent(stars)
						.addComponent(restart)
						.addComponent(quit))
				);
		this.setLayout(gl_contentPanel);
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(buttonPane, BorderLayout.SOUTH);

	}

}
