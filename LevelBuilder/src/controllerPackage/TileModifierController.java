package controllerPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import boundaryPackage.PalettePanel;
import entityPackage.ITileModifier;
import entityPackage.LevelModel;
import entityPackage.ModifyTileMove;

/**
 * Used to set the board model's current tile modifier.
 * @author Dean Kiourtsis, Dabai
 *
 */
public class TileModifierController extends MouseAdapter{
	
	/** A reference to the model. */
	LevelModel lm;
	
	/** The type of tile modifier action to be done. */
	ITileModifier itm;
	
	/** A reference to the palette panel. */
	PalettePanel pp;
	
	/**
	 * Constructor for a tile modifier controller.
	 * @param lm a reference to the model.
	 * @param itm the type of tile modifier action.
	 * @param pp a reference to the palette panel.
	 */
	public TileModifierController(LevelModel lm, ITileModifier itm, PalettePanel pp){
		this.lm = lm;
		this.itm = itm;
		this.pp = pp;
	}
	
	/**
	 * Once the modifier has been clicked in the palate,
	 * controller will set the current modifier to the clicked modifier
	 * 
	 * @param me mouse event, which is a mouse click on a tile modifier
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		lm.setTileModifier(itm);
		lm.setCurrentMove(new ModifyTileMove(lm, itm));
	}
}
