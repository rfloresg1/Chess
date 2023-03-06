package model;

import java.util.ArrayList;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class DeletedPieceManager implements IDeletedPieceManager{

    private List<Piece> pieces;

    public DeletedPieceManager(){ pieces = new ArrayList<>();}

    @Override
    public void addPiece(Piece piece){
        pieces.add(piece);
    }
    public int count(Piece.Type type){
        return (int) pieces.stream().count();
    }
    public Piece removeLast(){
        return pieces.remove(0);
    }

    @Override
    public String toString() {
        String output = "";

        for (Piece.Type type : Piece.Type.values())
            output += colorize(" " + type.getShape() + " ", type.getColor().getPieceColor(), Cell.Color.BLACK_CELL.getAttribute());

        output += "\n";

        for (Piece.Type type : Piece.Type.values())
            //output += colorize(" " + pieces.count(type) +" ",type.getColor().getPieceColor(),Cell.Color.WHITE_CELL.getAttribute());

            return output;

        return output;
    }

}