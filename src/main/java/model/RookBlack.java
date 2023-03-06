package model;

import java.util.Set;

public class RookBlack extends Rook{
    public RookBlack(Cell cell) {
        super(Type.BLACK_ROOK, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        return null;
    }
}