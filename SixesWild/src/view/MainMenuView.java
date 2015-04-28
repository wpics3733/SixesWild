package view;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.PastLevelViewController;
import controller.ShowCreditController;

public class MainMenuView extends JPanel {
	
	static final long serialVersionUID = 1;
	JLabel titleText;
	JButton continueButton;
	JButton levelsButton;
	JButton achievementsButton;
	JButton creditsButton;
	
	public MainMenuView(Application a) {
		super();
		
		this.titleText = new JLabel("Sixes Wild", SwingConstants.CENTER);
		titleText.setFont(new Font("Sans", Font.PLAIN, 20));
		this.continueButton = new JButton("Continue");
		this.levelsButton = new JButton("View Past Levels");
		this.achievementsButton = new JButton("Achievements");
		this.creditsButton = new JButton("Credits");
		
		this.levelsButton.addMouseListener(new PastLevelViewController(a));
		this.creditsButton.addMouseListener(new ShowCreditController(a));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, groupLayout.createSequentialGroup()
					.addContainerGap(0, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						.addComponent(titleText)
						.addComponent(creditsButton)
						.addComponent(achievementsButton)
						.addComponent(levelsButton)
						.addComponent(continueButton))
					.addContainerGap(0, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(titleText)
					.addGap(50)
					.addComponent(continueButton)
					.addComponent(levelsButton)
					.addComponent(achievementsButton)
					.addComponent(creditsButton)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
