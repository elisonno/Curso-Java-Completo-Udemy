package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
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

        return possiblePositions;
    }
}
