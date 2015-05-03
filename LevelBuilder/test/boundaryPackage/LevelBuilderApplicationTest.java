package boundaryPackage;

import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import junit.framework.TestCase;

/**
 * Tests the launch of the LevelBuilder application, and the flow of events
 * from one panel to the next panel.
 * @author Tom
 *
 */
public class LevelBuilderApplicationTest extends TestCase {
	LevelBuilderApplication app;
	
	
	public void setUp() {
		app = new LevelBuilderApplication(); 
		
	}
	
	/**
	 * Tests the flow of events, from one panel to the next.
	 * 
	 * (Also, just begun testing the validate() method in PropertiesMenuPanelController.  See the last few lines of this method.
	 * I probably will separate it into its own test case later on.)
	 * 
	 *  @author Tom
	 */
	public void testApplicationLaunch() {
		SplashScreenPanel splash = (SplashScreenPanel) app.getCurrentView();
		MouseEvent splashPress = new MouseEvent(splash, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, splash.getX(), splash.getY(), 1, false);		
		printMouseListeners(splash);
		splash.getMouseListeners()[0].mousePressed(splashPress);
		assertTrue(app.getCurrentView().toString().contains("MenuPanel"));
		
		MenuPanel menu = (MenuPanel) app.getCurrentView();
		JButton newLevelButton = menu.getNewLevelButton();
		MouseEvent newLevelButtonPress = new MouseEvent(newLevelButton, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, newLevelButton.getX(), newLevelButton.getY(), 1, false);
		printMouseListeners(newLevelButton);
		newLevelButton.getMouseListeners()[1].mousePressed(newLevelButtonPress);
		assertTrue(app.getCurrentView().toString().contains("LevelEditorPanel"));
		
		LevelEditorPanel levelEditor = (LevelEditorPanel) app.getCurrentView();
		PropertiesMenuPanel properties = (PropertiesMenuPanel) levelEditor.getPropertiesMenuPanel();
		JButton applyButton = properties.getBtnApply();
		MouseEvent applyButtonPress = new MouseEvent(applyButton, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, applyButton.getX(), applyButton.getY(), 1, false);
		printMouseListeners(applyButton);
		applyButton.getMouseListeners()[1].mousePressed(applyButtonPress);
		
		// continue to add more assertTrue() tests here.
		
	}
	
	/**
	 * Prints out all of the mouse listeners for a specified Component.
	 * If there are no listeners for the specified component, then it will print out a message saying so.
	 * @param component a swing component
	 * 
	 * @author Tom
	 */
	public void printMouseListeners(Component component) {
		try {
			String componentString = component.toString();
			String delims = "[.\\[]+";
			String[] tokens = componentString.split(delims);
			String componentName = tokens[1];
		
			if (component.getMouseListeners().length <= 0) {
				System.out.println("LevelBuilderApplicationTest::No mouse listeners found for " + componentName + ".");
				return;
			}
			
			System.out.println("LevelBuilderApplicationTest::Printing mouse listeners for " + componentName + "...");
			for (int i = 0; i < component.getMouseListeners().length; i++) {
				System.out.println("\t" + component.getMouseListeners()[i].toString());
			}
		}
		catch(Exception e) {
			System.err.println("LevelBuilderApplicationTest::printMouseListeners() failed.");
		}
	}

}
