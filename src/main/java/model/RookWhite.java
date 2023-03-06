package model;

import java.util.Set;

public class RookWhite extends Rook{
    public RookWhite(Cell cell) {
        super(Type.WHITE_ROOK, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        return null;
    }
}