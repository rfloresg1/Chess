package model;

import java.util.Set;

public class QueenWhite extends Queen{

    public QueenWhite(Cell cell) {
        super(Type.WHITE_QUEEN, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        return null;
    }
}