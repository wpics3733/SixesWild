package view;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Achievement;

/**
 * The top level JFrame for the SixesWild game
 * Every other Full screen panel in the game is displayed by adding itself to this JFrame
 * @author jesse
 *
 */
public class Application extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private Container pane;

	private JPanel current_view;

	/**
	 * Make a new Application
	 * It will default to showing the Splash Screen
	 */
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
	 * Switches the current view of the Application frame.
	 * Used when nagigating from Main Menu to a LevelView, or back, etc
	 * @param p the new focus panel
	 */
	public void changeView( JPanel p ) {
		pane.remove(current_view);
		this.current_view = p;
		pane.add(current_view);
		pane.validate();
		pane.repaint();
	}
	
	/**
	 * Returns the current view of the Application
	 * Used for testing
	 * @return	the current view
	 */
	public JPanel getCurrentView() {
		return current_view;
	}
}