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
        // Король может двигаться на одну клетку в любом направлении
        int rowDiff = Math.abs(startRow - endRow);
        int colDiff = Math.abs(startCol - endCol);

        if(rowDiff > 1 || colDiff > 1) {
            return false;
        }

        // Проверяем, не пытается ли король захватить свою фигуру
        Piece target = board.getPiece(endRow, endCol);
        return target == null || !target.getColor().equals(getColor());
    }
}
