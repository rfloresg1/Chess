
package model;

import java.util.HashSet;
import java.util.Set;

public class PawnBlack extends Pawn {
    public PawnBlack(Cell cell){
        super(Type.BLACK_PAWN, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        Set<Coordinate> nextMovements = new HashSet<>();
        Coordinate destination;

        destination = getPosition().down();
        if (canMoveTo(destination))
            nextMovements.add(destination);
        if(getCell().getCoordinate().getRow()==2){
            destination = getPosition().down().down();
            if (canMoveTo(destination))
                nextMovements.add(destination);
        }

        destination = getPosition().diagonalDownLeft();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        destination = getPosition().diagonalDownRight();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        return nextMovements;
    }

    @Override
    public void transform() {
        new QueenBlack(getCell());
        cell=null;
    }

}

