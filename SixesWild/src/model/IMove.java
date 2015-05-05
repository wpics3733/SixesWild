package model;

import java.util.ArrayList;

/**
 * The generic Move interface
 * All moves have to be able to have tiles added, and push themselves to
 * a level
 * They also have to know whether or not they are valid
 * @author jesse
 *
 */
public interface IMove {
	
	public boolean addTile(AbstractTileContainer tc);
	
	public void pushMove(Level l);
	
	public boolean isValid();
	
	public ArrayList<AbstractTileContainer> getTiles();

}
