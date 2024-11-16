package models;

/**
 * Представляет короля в шахматах.
 * Реализует правила передвижения короля.
 */
public class King extends Piece {

    public King(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Board board) {
        return (startRow == endRow && startCol == endCol);
    }
}
