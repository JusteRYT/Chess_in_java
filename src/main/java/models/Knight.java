package models;

/**
 * Представляет рыцаря в шахматах.
 * Реализует правила передвижения рыцаря.
 */
public class Knight extends Piece {

    public Knight(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Board board) {
        return (startRow == endRow && startCol == endCol);
    }
}
