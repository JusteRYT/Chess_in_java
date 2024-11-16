package models;

/**
 * Представляет ладью в шахматах.
 * Реализует правила передвижения ладьи.
 */
public class Rook extends Piece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Board board) {
        // Ладья ходит по прямым линиям
        return (startRow == endRow || startCol == endCol);
    }
}
