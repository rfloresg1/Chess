
package view;

import model.*;

import java.util.List;
import java.util.Set;

public class PruebaMain {
    public static void main(String[] args) {
        Board b1 = new Board();
        Screen.show(b1);

        b1.placePieces();
        Screen.show(b1);

        Set<Coordinate> coordinate = b1.getCell(new Coordinate('G',8)).getPiece().getNextMovements();
        b1.highlight(coordinate);
        Screen.show(b1);





    }
}