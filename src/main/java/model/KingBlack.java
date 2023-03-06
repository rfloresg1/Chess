package model;

import java.util.Set;

public class KingBlack extends King{

    public KingBlack(Cell cell) {
        super(Type.BLACK_KING, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        return null;
    }
}

