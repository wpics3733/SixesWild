import model.*;
import view.*;

public class Main {
	
	public static void main( String args[]) {
		
		Board b = new Board(9,9);
		LevelView a = new LevelView( b );
		a.frame.setVisible(true);		
		
	}
}
