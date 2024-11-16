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
        // Конь двигается буквой "Г"
        int rowDiff = Math.abs(startRow - endRow);
        int colDiff = Math.abs(startCol - endCol);
        if(!((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2))){
            return false;
        }

        // Проверяем, не пытается ли конь захватить свою фигуру
        Piece target = board.getPiece(endRow, endCol);
        return target == null || target.getColor().equals(getColor());
    }
}
