package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] possiblePositions = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position newPosition = new Position(0,0);

        //nw
        newPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
        while (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
            newPosition.setValues(newPosition.getRow() - 1, newPosition.getColumn() - 1);
        }
        if(getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //ne
        newPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
        while (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
            newPosition.setValues(newPosition.getRow() - 1, newPosition.getColumn() + 1);
        }
        if(getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //se
        newPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
        while (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
            newPosition.setValues(newPosition.getRow() + 1, newPosition.getColumn() + 1);
        }
        if(getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //sw
        newPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
        while (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
            newPosition.setValues(newPosition.getRow() + 1, newPosition.getColumn() - 1);
        }
        if(getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)){
            possiblePositions[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        return possiblePositions;
    }
}
