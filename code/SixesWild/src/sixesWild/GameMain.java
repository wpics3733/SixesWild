package sixesWild;
import sixesWild.model.*;
import sixesWild.view.*;

public class GameMain {
	
	public static void main( String args[]) {
		
		Level l = new Level(9,9);
		GameApplication a = new GameApplication(l);
		a.getFrame().setVisible(true);		
		
	}
}
