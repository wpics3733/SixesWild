
import javax.swing.JFrame;

import view.Application;

/**
 * The main class, initializes the Application and sets it to visible
 * @author jesse
 *
 */
public class Main {
	public static void main(String[] args) {
		
		Application app = new Application();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}
