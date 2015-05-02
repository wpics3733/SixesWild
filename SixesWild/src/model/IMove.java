package model;

import java.util.ArrayList;

public interface IMove {
	
	public boolean addTile(AbstractTileContainer tc);
	
	public void pushMove(Level l);
	
	public boolean isValid();
	
	public ArrayList<AbstractTileContainer> getTiles();

}
