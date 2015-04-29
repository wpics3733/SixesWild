package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.RestartLevelController;
import model.Level;

public class GameWestPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	
	JPanel star1, star2, star3;
	JProgressBar bar1, bar2, bar3;
	//Milestones: three stars is m0 + m1 + m2
	int m0, m1, m2;
	JButton restart;
	
	Level l;
	
	public GameWestPanel(Level l, LevelView parent) {
		this.l = l;

		bar1 = new JProgressBar();
		bar2 = new JProgressBar();
		bar3 = new JProgressBar();
		bar1.setValue(0);
		bar2.setValue(0);
		bar3.setValue(0);
		
		int total_height = 700;
		m0 = l.getMilestones()[0];
		m1 = l.getMilestones()[1] - m0;
		m2 = l.getMilestones()[2] - m1 - m0;
		int bar_height = m0 + m1 + m2;
		if(bar_height == 0) {
			m0 = 1;
			m1 = 1;
			m2 = 1;
			bar_height = 3;
		}
		
		bar1.setPreferredSize(new Dimension(15, m0 * total_height / bar_height)); 
		bar2.setPreferredSize(new Dimension(15, m1 * total_height / bar_height)); 
		bar3.setPreferredSize(new Dimension(15, m2 * total_height / bar_height)); 
		
		

		
		restart = new JButton("<html><center>Restart<br>Level<center></html>");
		restart.addMouseListener(new RestartLevelController(l, parent));
		restart.addMouseMotionListener(new RestartLevelController(l, parent));

		bar1.setOrientation(SwingConstants.VERTICAL);
		bar2.setOrientation(SwingConstants.VERTICAL);
		bar3.setOrientation(SwingConstants.VERTICAL);

		JLabel threeStar = new JLabel("3 Stars (" + l.getMilestones()[2] + ")");
		JLabel twoStar = new JLabel("2 Stars (" + l.getMilestones()[1] + ")");
		JLabel oneStar = new JLabel("1 Stars (" + l.getMilestones()[0] + ")");

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(bar1, 0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bar2, 0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bar3, 0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(twoStar)
						.addComponent(threeStar)
						.addComponent(oneStar)
						.addComponent(restart)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(threeStar, Alignment.LEADING)
						.addComponent(bar3, 0, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(bar2, 0, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
						.addComponent(twoStar))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(oneStar)
						.addComponent(bar1, 0, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGap(0,0, Short.MAX_VALUE)
							.addComponent(restart))
		);
		setLayout(groupLayout);

	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		bar1.setValue(100*l.getScore()/m0);
		bar2.setValue((100*(l.getScore()-m0))/m1);
		bar3.setValue((100*(l.getScore()-m0-m1))/m2);
	}
}
