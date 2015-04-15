package sixesWild.model;

public interface IMove {
	
	public boolean addTile(TileContainer tc);
	
	public int getScore();
	
	public void pushMove(Level l);
	
	public boolean isValid();

}
