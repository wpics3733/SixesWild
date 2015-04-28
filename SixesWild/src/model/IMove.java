package model;

import java.util.ArrayList;

public interface IMove {
	
	public boolean addTile(TileContainer tc);
	
	public void pushMove(Level l);
	
	public boolean isValid();
	
	public ArrayList<TileContainer> getTiles();

}
