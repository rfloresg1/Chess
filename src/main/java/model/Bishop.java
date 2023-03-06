
package model;

import java.util.HashSet;
import java.util.Set;

public abstract class Bishop extends Piece{
    public Bishop(Type type, Cell cell){
        super(type, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements(){
        return Bishop.getNextMovementsAsBishop(this);
    }

    public static Set<Coordinate> getNextMovementsAsBishop(Piece p){
        Set<Coordinate> nextMovements = new HashSet<>();
        Cell cell = p.getCell();
        Board board = cell.getBoard();
        Piece.Color color = p.getColor();

        Coordinate destination;

        //DIAGONAL UP LEFT
        destination = p.getPosition().diagonalUpLeft();
        while(board.getCell(destination)!= null && board.getCell(destination).isEmpty()) {
            nextMovements.add(destination);
            destination = destination.diagonalUpLeft();
        }
        if(p.canMoveTo(destination))
            nextMovements.add(destination);

        //DIAGONAL UP RIGHT
        destination = p.getPosition().diagonalUpRight();
        while(board.getCell(destination)!= null && board.getCell(destination).isEmpty()) {
            nextMovements.add(destination);
            destination = destination.diagonalUpRight();
        }
        if(p.canMoveTo(destination))
            nextMovements.add(destination);

        //DIAGONAL DOWN LEFT
        destination = p.getPosition().diagonalDownLeft();
        while(board.getCell(destination)!= null && board.getCell(destination).isEmpty()) {
            nextMovements.add(destination);
            destination = destination.diagonalDownLeft();
        }
        if(p.canMoveTo(destination))
            nextMovements.add(destination);

        //DIAGONAL DOWN RIGHT
        destination = p.getPosition().diagonalDownRight();
        while(board.getCell(destination)!= null && board.getCell(destination).isEmpty()) {
            nextMovements.add(destination);
            destination = destination.diagonalDownRight();
        }
        if(p.canMoveTo(destination))
            nextMovements.add(destination);

        return nextMovements;

    }
}