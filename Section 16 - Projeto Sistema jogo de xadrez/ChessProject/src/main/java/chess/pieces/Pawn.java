package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] possiblePositions = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position newPosition = new Position(0,0);

        if(getColor() == Color.WHITE){
            newPosition.setValues(position.getRow() - 1, position.getColumn());
            if(getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)){
                possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
            }
            newPosition.setValues(position.getRow() - 2, position.getColumn());
            Position newPosition2 = new Position(position.getRow() - 1, position.getColumn());
            if(getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition) && getBoard().positionExists(newPosition2) && !getBoard().thereIsAPiece(newPosition2) && getMoveCount() == 0){
                possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
            }
            newPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
            if(getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)){
                possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
            }
            newPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
            if(getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)){
                possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
            }

            //special move en passant white
            if(position.getRow() == 3){
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()){
                    possiblePositions[left.getRow() - 1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()){
                    possiblePositions[right.getRow() - 1][right.getColumn()] = true;
                }
            }

        }
        else{
            newPosition.setValues(position.getRow() + 1, position.getColumn());
            if(getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)){
                possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
            }
            newPosition.setValues(position.getRow() + 2, position.getColumn());
            Position newPosition2 = new Position(position.getRow() + 1, position.getColumn());
            if(getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition) && getBoard().positionExists(newPosition2) && !getBoard().thereIsAPiece(newPosition2) && getMoveCount() == 0){
                possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
            }
            newPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
            if(getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)){
                possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
            }
            newPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
            if(getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)){
                possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
            }

            //special move en passant black
            if(position.getRow() == 4){
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()){
                    possiblePositions[left.getRow() + 1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()){
                    possiblePositions[right.getRow() + 1][right.getColumn()] = true;
                }
            }
        }

        return possiblePositions;
    }

    @Override
    public String toString() {
        return "P";
    }
}
