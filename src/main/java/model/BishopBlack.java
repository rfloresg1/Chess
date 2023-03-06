package model;

import java.util.Set;

public class BishopBlack extends Bishop{

    public BishopBlack(Cell cell) {
        super(Type.BLACK_BISHOP, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        return null;
    }
}