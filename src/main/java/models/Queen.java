package models;

/**
 * Представляет королеву в шахматах.
 * Реализует правила передвижения королевы.
 */
public class Queen extends Piece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Board board) {
        return (startRow == endRow && startCol == endCol);
    }
}
