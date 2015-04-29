package controllerPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import boundaryPackage.PalettePanel;
import entityPackage.ITileModifier;
import entityPackage.LevelModel;

public class TileModifierController extends MouseAdapter{
	LevelModel lm;
	ITileModifier itm;
	PalettePanel pp;
	
	public TileModifierController(LevelModel lm, ITileModifier itm, PalettePanel pp){
		this.lm = lm;
		this.itm = itm;
		this.pp = pp;
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		lm.setTileModifier(itm);
	}
}
