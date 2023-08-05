package chess;

import boardgame.Board;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] partsMatrix = new ChessPiece[board.getRows()][board.getColumns()];
        for(int row=0; row<board.getRows(); row++){
            for(int column=0; column< board.getColumns(); column++){
                partsMatrix[row][column] = (ChessPiece) board.piece(row,column);
            }
        }
        return partsMatrix;
    }
}
