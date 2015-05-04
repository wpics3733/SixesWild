package controllerPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import boundaryPackage.PalettePanel;
import entityPackage.ITileModifier;
import entityPackage.LevelModel;
import entityPackage.ModifyTileMove;

/** The tile modifier controller
 * @author Dabai
 *
 */
public class TileModifierController extends MouseAdapter{
	LevelModel lm;
	ITileModifier itm;
	PalettePanel pp;
	
	public TileModifierController(LevelModel lm, ITileModifier itm, PalettePanel pp){
		this.lm = lm;
		this.itm = itm;
		this.pp = pp;
	}
	
	/**
	 * Once the modifier has been clicked in the palate,
	 * controller will set the current modifier to the clicked modifier
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		lm.setTileModifier(itm);
		lm.setCurrentMove(new ModifyTileMove(lm, itm));
	}
}
