package SixesWild.Models;

public class Square {

    Location location;
    Tile tile;

    public Square() {

    }

    public Square(Location location, Tile tile) {
        this.location = location;
        this.tile = tile;
    }

    public boolean isAdjacent(Square square) {
        return location.isAdjacent(square.getLocation());
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public boolean isEmpty() {
        if(tile == null) {
            return true;
        }

        return false;
    }

    public boolean isContainer() {
        return false;
    }
}