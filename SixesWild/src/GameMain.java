import model.*;
import view.*;

public class GameMain {
	
	public static void main( String args[]) {
		
		Level l = new Level(7,5);
		GameApplication a = new GameApplication(l);
		a.getFrame().setVisible(true);		
		
	}
}
