package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    private boolean testRokkCastling(Position position){
        ChessPiece pieceRook = (ChessPiece)getBoard().piece(position);
        return pieceRook instanceof Rook && pieceRook.getColor() == getColor() && pieceRook.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] possiblePositions = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position newPosition = new Position(0,0);

        //above
        newPosition.setValues(position.getRow() - 1, position.getColumn());
        if(getBoard().positionExists(newPosition) && canMove(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //above
        newPosition.setValues(position.getRow() + 1, position.getColumn());
        if(getBoard().positionExists(newPosition) && canMove(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //left
        newPosition.setValues(position.getRow(), position.getColumn() - 1);
        if(getBoard().positionExists(newPosition) && canMove(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //right
        newPosition.setValues(position.getRow(), position.getColumn() + 1);
        if(getBoard().positionExists(newPosition) && canMove(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //nw
        newPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
        if(getBoard().positionExists(newPosition) && canMove(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //ne
        newPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
        if(getBoard().positionExists(newPosition) && canMove(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //sw
        newPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
        if(getBoard().positionExists(newPosition) && canMove(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //se
        newPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
        if(getBoard().positionExists(newPosition) && canMove(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //special move castling
        if(getMoveCount() == 0 && !chessMatch.getCheck()){
            //special move castling king side rook
            Position positionRook1 = new Position(position.getRow(), position.getColumn() + 3);
            if(testRokkCastling(positionRook1)){
                Position position1 = new Position(position.getRow(), position.getColumn() + 1);
                Position position2 = new Position(position.getRow(), position.getColumn() + 2);
                if( getBoard().piece(position1) == null && getBoard().piece(position2) == null) {
                    possiblePositions[position.getRow()][position.getColumn() + 2] = true;
                }
            }

            //special move castling queen side rook
            Position positionRook2 = new Position(position.getRow(), position.getColumn() - 4);
            if(testRokkCastling(positionRook2)){
                Position position1 = new Position(position.getRow(), position.getColumn() - 1);
                Position position2 = new Position(position.getRow(), position.getColumn() - 2);
                Position position3 = new Position(position.getRow(), position.getColumn() - 2);
                if(getBoard().piece(position1) == null && getBoard().piece(position2) == null && getBoard().piece(position3) == null){
                    possiblePositions[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return possiblePositions;
    }
}
