package view;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Achievement;

public class Application extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private Container pane;

	private JPanel current_view;

	public Application() {
		super("SixesWild");
		pane = this.getContentPane();
		
		
		current_view = new SplashPanel(this);
		
		this.setPreferredSize(new Dimension(1024, 768));
		this.changeView(current_view);
		
		this.pack();
		this.setResizable(false);
		
		// I couldn't think of a better place for this, so here it is.
		// First we intstantiate all the achievements, then we load the save file.
		// - justin
		Achievement.initializeAll();
	}
	
	/**
	 * Switches
	 * @param p
	 */
	public void changeView( JPanel p ) {
		pane.remove(current_view);
		this.current_view = p;
		pane.add(current_view);
		pane.validate();
		pane.repaint();
	}
}