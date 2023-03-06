package model;

import com.diogonunes.jcolor.Attribute;

import java.util.Set;

import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Piece {
    protected Set<Coordinate> coordinates;
    private Type type;
    protected Cell cell;

    public Piece(Type type, Cell cell) {
        this.cell = cell;
        this.type = type;
        putInYourPlace();
    }

    public Cell getCell(){
        return cell;
    }

    public Coordinate getPosition(){
        return cell.getCoordinate();
    }

    public Color getColor() {
        return type.color;
    }

    public Type getType(){return type;}


    private void putInYourPlace(){
        cell.setPiece(this);
    }

    protected void removePiece(){
        cell.setPiece(null);
        cell=null;
    }

    public abstract Set<Coordinate> getNextMovements();

//    protected void check(Coordinate coordinate, ListCoor coordinates){
//        Board board = getCell().getBoard();
//
//        if (board.getCell(coordinate) != null)
//            if (board.getCell(coordinate).isEmpty() ||
//                    board.getCell(coordinate).getPiece().getColor() != getColor())
//                coordinates.add(coordinate);
//    }

    public boolean moveTo(Cell destination){
        if (cell == null || !getNextMovements().contains(destination.getCoordinate()))
            return false;

        if (destination.containsPiece()){
            destination.getPiece().removePiece();
        }

        cell.setPiece(null);
        cell = destination;
        putInYourPlace();
        return true;
    }


    protected boolean canMoveTo(Coordinate destination){
        Cell cell = this.cell.getBoard().getCell(destination);

        if (cell == null)
            return false;

        if (cell.isEmpty())
            return true;

        if (cell.getPiece().getColor() != getColor())
            return true;

        return false;
    }

    @Override
    public String toString(){
        return colorize(type.toString(),type.color.getPieceColor(),cell.getColor().getAttribute());
    }

    public enum Color{
        WHITE(Attribute.TEXT_COLOR(255)),
        BLACK(Attribute.TEXT_COLOR(16));
        private final Attribute pieceColor;
        private Color(Attribute pieceColor){
            this.pieceColor = pieceColor;
        }
        public Attribute getPieceColor() { return pieceColor;}
        public Color next(){
            if(this.equals(WHITE))
                return BLACK;
            return WHITE;
        }
    }

    public enum Type{
        WHITE_KING("\u265A", Color.WHITE),
        BLACK_KING("\u265A", Color.BLACK),
        WHITE_QUEEN("\u265B", Color.WHITE),
        BLACK_QUEEN("\u265B", Color.BLACK),
        WHITE_ROOK("\u265C", Color.WHITE),
        BLACK_ROOK("\u265C", Color.BLACK),
        WHITE_BISHOP("\u265D", Color.WHITE),
        BLACK_BISHOP("\u265D", Color.BLACK),
        WHITE_KNIGHT("\u265E", Color.WHITE),
        BLACK_KNIGHT("\u265E", Color.BLACK),
        WHITE_PAWN("\u2659", Color.WHITE),
        BLACK_PAWN("\u2659", Color.BLACK);
        private String shape;
        private Color color;
        private Type(String shape, Color color) {
            this.color = color;
            this.shape = shape;
        }
        public Color getColor() {
            return color;
        }
        public String getShape() {
            return shape;
        }

        @Override
        public String toString() {
            return String.valueOf(shape);
        }
    }
}