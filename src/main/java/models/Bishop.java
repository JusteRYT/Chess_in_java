package models;

/**
 * Представляет слона в шахматах.
 * Реализует правила передвижения слона.
 */
public class Bishop extends Piece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Board board) {
        return startRow == endRow && startCol == endCol;
    }
}
