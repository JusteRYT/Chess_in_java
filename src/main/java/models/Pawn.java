package models;

/**
 * Пешка.
 * Реализует определенные правила перемещения
 */
public class Pawn extends Piece {

    public Pawn (String color){
        super(color);
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Board board) {
        return true;
    }
}
