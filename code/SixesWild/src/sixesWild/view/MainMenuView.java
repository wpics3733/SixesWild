package sixesWild.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MainMenuView extends JPanel {
	
	static final long serialVersionUID = 1;
	JLabel titleText;
	JButton continueButton;
	JButton levelsButton;
	JButton achievementsButton;
	JButton creditsButton;
	
	public MainMenuView() {
		super();
		
		this.titleText = new JLabel("Sixes Wild", SwingConstants.CENTER);
		this.continueButton = new JButton("Continue");
		this.levelsButton = new JButton("View Past Levels");
		this.achievementsButton = new JButton("Achievements");
		this.creditsButton = new JButton("Credits");
		
		GroupLayout groupLayout = new GroupLayout(this);
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
					.addGap(179))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(titleText)
					.addGap(50)
					.addComponent(continueButton)
					.addGap(20)
					.addComponent(levelsButton)
					.addGap(20)
					.addComponent(achievementsButton)
					.addGap(20)
					.addComponent(creditsButton)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
