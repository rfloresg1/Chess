package model;

import java.util.HashSet;
import java.util.Set;

public class PawnWhite extends Pawn{
    public PawnWhite(Cell cell){
        super(Type.WHITE_PAWN, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {

        Set<Coordinate> nextMovements = new HashSet<>();
        Coordinate destination;

        // UP
        destination = getPosition().up();
        if (canMoveTo(destination))
            nextMovements.add(destination);
        if(getCell().getCoordinate().getRow()==7){
            destination = getPosition().down().down();
            if (canMoveTo(destination))
                nextMovements.add(destination);
        }

        // Diagonal Up Left
        destination = getPosition().diagonalUpLeft();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        // Diagonal Up Right
        destination = getPosition().diagonalUpRight();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        return nextMovements;
    }

    @Override
    public void transform() {
        new QueenWhite(getCell());
        cell=null;
    }

}