package SixesWild.Models;

/**
 *
 */
public class Location {

    Value column;
    Value row;

    public Location(Value column, Value row) {
        this.column = column;
        this.row = row;
    }

    public Value getColumn() {
        return column;
    }

    public void setColumn(Value column) {
        this.column = column;
    }

    public Value getRow() {
        return row;
    }

    public void setRow(Value row) {
        this.row = row;
    }

    public boolean isAdjacent(Location location) {
        boolean validation = false;

        if (location.getRow().getValue() == row.getValue()
                && ((location.getColumn().getValue() == column.getValue() + 1)
                || (location.getColumn().getValue() == column.getValue() - 1))) {
            validation = true;
        }

        if (location.getColumn().getValue() == column.getValue()
                && ((location.getRow().getValue() == row.getValue() + 1)
                || (location.getColumn().getValue() == row.getValue() - 1))) {
            validation = true;
        }

        return validation;
    }
}