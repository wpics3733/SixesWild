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

import controller.ClosePopupController;
import controller.RestartLevelController;
import controller.ReturnToMenuController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import model.Level;

public class EndLevelPopup extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JButton quit, restart;
	JLabel winMessage;
	JLabel score;

	public EndLevelPopup(Level l, LevelView lv, Application parent) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		if(l.getScore() >= l.getMilestones()[0]) {
			winMessage = new JLabel("You Win");
		} else {
			winMessage = new JLabel("You lose");
		}
		winMessage.setFont(new Font("Sans", Font.PLAIN, 20));
		score = new JLabel("Score: " + l.getScore());
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setAutoCreateContainerGaps(true);
		gl_contentPanel.setAutoCreateGaps(true);

		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_contentPanel.createSequentialGroup()
					.addContainerGap(0, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.CENTER)
						.addComponent(winMessage)
						.addComponent(score))
					.addContainerGap(0, Short.MAX_VALUE))
		);

		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_contentPanel.createSequentialGroup()
					.addComponent(winMessage)
					.addComponent(score))
		);
		contentPanel.setLayout(gl_contentPanel);
		this.setModal(true);
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		restart = new JButton("Restart");
		restart.addMouseListener(new RestartLevelController(lv.getLevel(), lv));
		restart.addMouseListener(new ClosePopupController(this));
		buttonPane.add(restart);

		quit = new JButton("Quit");
		quit.addMouseListener(new ReturnToMenuController(parent));
		quit.addMouseListener(new ClosePopupController(this));
		buttonPane.add(quit);
		String message = lv.getLevel().getScore() >= lv.getLevel().getMilestones()[0] ? "You win" : "You failed";
		
		String scoreString = "Score: " + lv.getLevel().getScore();
	}

}
