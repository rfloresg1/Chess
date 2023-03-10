package model;

import java.util.*;
import java.util.stream.Collectors;

public class Board {

    private Map<Coordinate,Cell> cells;
    private IDeletedPieceManager deletedPieceManager;

    public Board(){

        cells = new HashMap<>();
        deletedPieceManager = new DeletedPieceManager();
        initializeCells();
    }

    private void initializeCells(){
        Coordinate coordinate;
        Cell cell;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                coordinate = new Coordinate((char)('A'+col), 1 + row);
                cell = new Cell(this, coordinate);
                cells.put(coordinate,cell);
            }
        }
    }

    public void highlight(Set<Coordinate> coordinates){
        for (Coordinate c : coordinates)
            cells.get(c).highlight();
    }

    public void removeHighlight(){
        for (Coordinate c : cells.keySet())
            cells.get(c).resetColor();
    }


    public Cell getCell(Coordinate c){
        return cells.get(c);
    }


    private List<Piece> getPieces(){
        return cells.values().stream()
                .filter(cell -> cell.containsPiece())
                .map(cell -> cell.getPiece())
                .collect(Collectors.toList());
    }

    public List<Piece> getWhitePieces(){
        return getPieces().stream()
                .filter(piece -> piece.getColor() == Piece.Color.WHITE)
                .collect(Collectors.toList());
    }

    public List<Piece> getBlackPieces(){
        return getPieces().stream()
                .filter(piece -> piece.getColor() == Piece.Color.BLACK)
                .collect(Collectors.toList());
    }

    public Piece getWhiteKing(){
        Optional<Piece> pieceOptional = getBlackPieces().stream()
                .filter(piece -> piece.getType() == Piece.Type.WHITE_KING)
                .findAny();
        return (pieceOptional.isPresent()) ? pieceOptional.get():null;
    }

    public Piece getBlackKing(){
        Optional<Piece> pieceOptional = getBlackPieces().stream()
                .filter(piece -> piece.getType() == Piece.Type.BLACK_KING)
                .findAny();
        return (pieceOptional.isPresent()) ? pieceOptional.get():null;
    }



    public void placePieces(){
        Piece p;
        p = new RookWhite(getCell(new Coordinate('A',8)));
        p = new RookWhite(getCell(new Coordinate('H',8)));
        p = new KnightWhite(getCell(new Coordinate('B',8)));
        p = new KnightWhite(getCell(new Coordinate('G',8)));
        p = new BishopWhite(getCell(new Coordinate('C',8)));
        p = new BishopWhite(getCell(new Coordinate('F',8)));
        p = new KingWhite(getCell(new Coordinate('D',8)));
        p = new QueenWhite(getCell(new Coordinate('E',8)));

        p = new RookBlack(getCell(new Coordinate('A',1)));
        p = new RookBlack(getCell(new Coordinate('H',1)));
        p = new KnightBlack(getCell(new Coordinate('B',1)));
        p = new KnightBlack(getCell(new Coordinate('G',1)));
        p = new BishopBlack(getCell(new Coordinate('C',1)));
        p = new BishopBlack(getCell(new Coordinate('F',1)));
        p = new KingBlack(getCell(new Coordinate('D',1)));
        p = new QueenBlack(getCell(new Coordinate('E',1)));

        for (int i = 0; i < 8; i++) {
            p = new PawnBlack(getCell(new Coordinate((char)('A'+i),2)));
            p = new PawnWhite(getCell(new Coordinate((char)('A'+i),7)));
        }


    }

    public void testPlacePawn(){
        Piece p;
        p = new PawnWhite(getCell(new Coordinate('B',6)));
//        p.putInYourPlace();
        p = new PawnWhite(getCell(new Coordinate('C',7)));
//        p.putInYourPlace();
        p = new PawnBlack(getCell(new Coordinate('D',6)));
//        p.putInYourPlace();
    }

    public void testPlaceBishop(){
        Piece p;
        p = new BishopWhite(getCell(new Coordinate('D',6)));
//        p.putInYourPlace();
        p = new BishopWhite(getCell(new Coordinate('F',4)));
//        p.putInYourPlace();
        p = new BishopBlack(getCell(new Coordinate('B',4)));
//        p.putInYourPlace();
    }

    public void testPlaceRook(){
        Piece p;
        p = new RookWhite(getCell(new Coordinate('D',6)));
//        p.putInYourPlace();
        p = new RookWhite(getCell(new Coordinate('A',6)));
//        p.putInYourPlace();
        p = new RookBlack(getCell(new Coordinate('H',6)));
//        p.putInYourPlace();
    }

    public void testPlaceQueen(){
        Piece p;
        p = new QueenWhite(getCell(new Coordinate('D',6)));
        //       p.putInYourPlace();
        p = new RookWhite(getCell(new Coordinate('A',6)));
        //      p.putInYourPlace();
        p = new RookBlack(getCell(new Coordinate('H',6)));
        //     p.putInYourPlace();
        p = new BishopWhite(getCell(new Coordinate('F',4)));
        //     p.putInYourPlace();
        p = new BishopBlack(getCell(new Coordinate('B',4)));
        //      p.putInYourPlace();
    }

    public void testPlaceKing(){
        Piece p;
        p = new KingWhite(getCell(new Coordinate('D',6)));
        //    p.putInYourPlace();
        p = new RookWhite(getCell(new Coordinate('E',6)));
        //   p.putInYourPlace();
        p = new RookBlack(getCell(new Coordinate('C',6)));
        //   p.putInYourPlace();
    }
    public void testPlaceKnight(){
        Piece p;
        p = new KnightWhite(getCell(new Coordinate('D',6)));
        //  p.putInYourPlace();
        p = new KnightWhite(getCell(new Coordinate('F',7)));
        //  p.putInYourPlace();
        p = new KnightBlack(getCell(new Coordinate('B',7)));
        // p.putInYourPlace();
    }


}