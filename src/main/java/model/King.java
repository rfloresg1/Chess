package model;

import java.util.HashSet;
import java.util.Set;

public abstract class King extends Piece{

    public King(Type type, Cell cell) {
        super(type, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        Set<Coordinate> nextMovements = new HashSet<>();
        //  Coordinate position = getCell().getCoordinate();
        Coordinate destination;

        //Up
        destination = getPosition().up();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        //Left
        destination = getPosition().left();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        //Down
        destination = getPosition().down();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        //right
        destination = getPosition().right();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        //Down Left
        destination = getPosition().diagonalDownLeft();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        //Down Right
        destination = getPosition().diagonalDownRight();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        //Up Left
        destination = getPosition().diagonalUpLeft();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        //Up Right
        destination = getPosition().diagonalUpRight();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        return nextMovements;

    }
}