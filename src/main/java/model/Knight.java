
package model;

import java.util.HashSet;
import java.util.Set;

public abstract class Knight extends Piece {

    public Knight(Type type, Cell cell) {
        super(type, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        Set<Coordinate> nextMovements = new HashSet<>();
        Coordinate destination;

        //Up
        destination = getPosition().up().up().right();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        destination = getPosition().up().up().left();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        //Down
        destination = getPosition().down().down().left();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        destination = getPosition().down().down().right();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        //Left
        destination = getPosition().left().left().up();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        destination = getPosition().left().left().down();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        //right
        destination = getPosition().right().right().down();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        destination = getPosition().right().right().up();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        return nextMovements;
    }


}