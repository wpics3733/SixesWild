package entityPackage;

import junit.framework.TestCase;

public class ModifierTests extends TestCase {
	
	public void testModifiers(){
		Tile t = new Tile(0,0);
		MarkModifier mod1 = new MarkModifier(0);
		ValueModifier mod2 = new ValueModifier(5);
		MultiplierModifier mod3 = new MultiplierModifier(3);
		
		mod1.modifyTile(t);
		mod2.modifyTile(t);
		mod3.modifyTile(t);
		assertEquals(0,t.mark);
		assertEquals(5,t.getValue());
		assertEquals(3,t.getMultiplier());
		
	}
	
}
