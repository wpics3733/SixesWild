package sixesWild.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Application extends JFrame{
	public Application() {
		super("SixWild");
		
		FlowLayout mainLayout = new FlowLayout();
		mainLayout.setHgap(0);
		mainLayout.setVgap(0);
		Container pane = this.getContentPane();
		
		pane.setPreferredSize(new Dimension(1024, 768));
		pane.setLayout(mainLayout);
		pane.add(new PastLevelPanel());
		
		this.pack();
		this.setResizable(false);
	}
}