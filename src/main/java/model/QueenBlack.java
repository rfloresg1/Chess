package model;

import java.util.Set;

public class QueenBlack extends Queen{

    public QueenBlack(Cell cell) {
        super(Type.BLACK_QUEEN, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        return null;
    }
}