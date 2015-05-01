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

public class EndLevelPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	JButton quit, restart;
	JLabel winMessage;
	JLabel score;

	public EndLevelPanel(Level l, LevelView lv, Application parent) {
		setBounds(100, 100, 450, 300);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		if(l.getScore() >= l.getMilestones()[0]) {
			winMessage = new JLabel("You Win");
		} else {
			winMessage = new JLabel("You lose");
		}
		winMessage.setFont(new Font("Sans", Font.PLAIN, 20));
		score = new JLabel("Score: " + l.getScore());

		restart = new JButton("Restart");
		restart.addMouseListener(new RestartLevelController(lv.getLevel(), lv));

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
						.addComponent(score)
						.addComponent(restart)
						.addComponent(quit))
					.addContainerGap(0, Short.MAX_VALUE))
		);

		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_contentPanel.createSequentialGroup()
					.addComponent(winMessage)
					.addComponent(score)
						.addComponent(restart)
						.addComponent(quit))
		);
		this.setLayout(gl_contentPanel);
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(buttonPane, BorderLayout.SOUTH);

	}

}
