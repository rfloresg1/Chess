package model;

public abstract class Pawn extends Piece {
    public Pawn(Type type, Cell cell) {
        super(type, cell);
    }

    public abstract void transform();

    @Override
    public boolean moveTo(Cell destination) {
        boolean moved = super.moveTo(destination);
        if (moved)
            if (cell.getCoordinate().getRow() == 1 && getColor() == Color.WHITE
                    || cell.getCoordinate().getRow() == 8 && getColor() == Color.BLACK)
                transform();

        return moved;
    }

//    protected void checkPawnKiller(Coordinate c) {
//        Board board = getCell().getBoard();
//        if ((board.getCell(c) != null) && (board.getCell(c).getPiece().getColor() != getColor()))
//            coordinates.add(c);
//    }
//
//    protected void checkPawnMove(Coordinate c) {
//        Board board = getCell().getBoard();
//        if ((board.getCell(c) != null) && (board.getCell(c).isEmpty()))
//            coordinates.add(c);
//    }
}