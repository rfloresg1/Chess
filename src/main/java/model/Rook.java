package model;

import java.util.HashSet;
import java.util.Set;

public abstract class Rook extends Piece{

    public Rook(Type type, Cell cell) {
        super(type, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        return Rook.getNextMovementsAsRook(this);
    }

    public static Set<Coordinate> getNextMovementsAsRook(Piece p){

        Set<Coordinate> nextMovements = new HashSet<>();
        Cell cell = p.getCell();
        Board board = cell.getBoard();
        Piece.Color color = p.getColor();

        //  Coordinate original = cell.getCoordinate();
        Coordinate destination;

        //UP
        destination = p.getPosition().up();
        while(board.getCell(destination)!= null && board.getCell(destination).isEmpty()) {
            nextMovements.add(destination);
            destination = destination.up();
        }
        if(p.canMoveTo(destination))
            nextMovements.add(destination);

        //DOWN
        destination = p.getPosition().down();
        while(board.getCell(destination)!= null && board.getCell(destination).isEmpty()) {
            nextMovements.add(destination);
            destination = destination.down();
        }
        if(p.canMoveTo(destination))
            nextMovements.add(destination);

        //LEFT
        destination = p.getPosition().left();
        while(board.getCell(destination)!= null && board.getCell(destination).isEmpty()) {
            nextMovements.add(destination);
            destination = destination.left();
        }
        if(p.canMoveTo(destination))
            nextMovements.add(destination);

        //RIGHT
        destination = p.getPosition().right();
        while(board.getCell(destination)!= null && board.getCell(destination).isEmpty()) {
            nextMovements.add(destination);
            destination = destination.right();
        }
        if(p.canMoveTo(destination))
            nextMovements.add(destination);

        return nextMovements;
    }


}
