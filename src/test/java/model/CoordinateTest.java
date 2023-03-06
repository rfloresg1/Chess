package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.SelectorResolutionResult;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    @DisplayName("New coordinate in up direction")
    void up() {
        Coordinate c1 = new Coordinate('c',2);
        Coordinate c2 = new Coordinate('c',3).up();
        assertEquals(c1,c2);
        assertEquals(new Coordinate('a',2), new Coordinate('A',3).up());
    }

    @Test
    @DisplayName("New cooordinate in down direction")
    void down() {
        Coordinate c1 = new Coordinate('c',3);
        Coordinate c2 = new Coordinate('c',2).down();
        assertEquals(c1,c2);
        assertEquals(new Coordinate('c',2),new Coordinate('C',1).down());

    }
    @Test
    @DisplayName("New coordinate in right direction")
    void right() {
        Coordinate c1 = new Coordinate('c',2);
        Coordinate c2 = new Coordinate('b',2).right();
        assertEquals(c1,c2);
        assertEquals(new Coordinate('c',2),new Coordinate('B',2).right());
    }

    @Test
    @DisplayName("New coordinate in left direction")
    void left() {
        Coordinate c1 = new Coordinate('b',2);
        Coordinate c2 = new Coordinate('c',2).left();
        assertEquals(c1,c2);
        assertEquals(new Coordinate('b',2),new Coordinate('C',2).left());
    }

    @Test
    @DisplayName("New coordinate in up left direction")
    void diagonalUpLeft() {
        Coordinate c1 = new Coordinate('b',2);
        Coordinate c2 = new Coordinate('c',3).diagonalUpLeft();
        assertEquals(c1,c2);
        assertEquals(new Coordinate('b',2),new Coordinate('C',3).diagonalUpLeft());
    }

    @Test
    @DisplayName("New coordinate in up right direction")
    void diagonalUpRight() {
        Coordinate c1 = new Coordinate('b',2);
        Coordinate c2 = new Coordinate('a',3).diagonalUpRight();
        assertEquals(c1,c2);
        assertEquals(new Coordinate('b',2),new Coordinate('A',3).diagonalUpRight());
    }

    @Test
    @DisplayName("New coordinate in down left direction")
    void diagonalDownLeft() {
        Coordinate c1 = new Coordinate('b',2);
        Coordinate c2 = new Coordinate('c',1).diagonalDownLeft();
        assertEquals(c1,c2);
        assertEquals(new Coordinate('b',2),new Coordinate('C',1).diagonalDownLeft());
    }

    @Test
    @DisplayName("New coordiante in down right direction")
    void diagonalDownRight() {
        Coordinate c1 = new Coordinate('b',2);
        Coordinate c2 = new Coordinate('a',1).diagonalDownRight();
        assertEquals(c1,c2);
        assertEquals(new Coordinate('b',2),new Coordinate('A',1).diagonalDownRight());
    }
}