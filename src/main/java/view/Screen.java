package view;

import model.Board;
import model.Coordinate;
import model.DeletedPieceManager;

public class Screen {

    public static void show(Board board){
        StringBuilder salida = new StringBuilder();
        salida.append(getLetters());

        for (int fila = 1; fila <= 8; fila++) {
            salida.append(getMiddlePart(board, fila));
        }
        salida.append(getLetters());
        System.out.println(salida);
        System.out.println(showDeletedPiece());
    }
    private static String showDeletedPiece(){
        DeletedPieceManager d1 = new DeletedPieceManager();
        return d1.toString();
    }

    private static String getLetters(){
        return "               A  B  C  D  E  F  G  H\n";
    }

    private static String getMiddlePart(Board board, int fila){

        StringBuilder salida = new StringBuilder("            " + fila + " ");
        for (int col = 0; col < 8; col++) {
            salida.append(board.getCell((new Coordinate((char) ('A' + col), fila))));
        }
        return salida.append(" " + fila + "\n").toString();
    }

}
