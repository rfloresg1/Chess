package model;

import java.util.Set;

public class BishopWhite extends Bishop{

    public BishopWhite(Cell cell) {
        super(Type.WHITE_BISHOP, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        return null;
    }
}