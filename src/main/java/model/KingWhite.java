
package model;

import java.util.Set;

public class KingWhite extends King{

    public KingWhite(Cell cell) {
        super(Type.WHITE_KING, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        return null;
    }
}