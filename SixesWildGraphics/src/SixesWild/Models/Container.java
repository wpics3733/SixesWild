package SixesWild.Models;

/**
 * Created by harryliu on 5/6/15.
 */
public class Container extends Square {

    public Container() {
    }

    public Container(Location location, Tile tile) {
        super(location, tile);
    }

    @Override
    public boolean isContainer() {
        return true;
    }
}
