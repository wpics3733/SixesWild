import model.*;
import view.*;

public class Main {
	
	public static void main( String args[]) {
		
		SixesGridModel m = new SixesGridModel(9,9);
		SixesWild a = new SixesWild( m );
		a.frame.setVisible(true);		
		
	}
}
