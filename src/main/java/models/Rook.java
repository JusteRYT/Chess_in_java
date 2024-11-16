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
        // Ладья ходит по прямым линиям, по строке или по столбцу
        if (startRow != endRow && startCol != endCol) {
            return false;
        }

        // Проверяем, что между начальной и конечной клетками нет других фигур
        int stepRow = Integer.compare(endRow, startRow);
        int stepCol = Integer.compare(endCol, startCol);
        int currentRow = startRow + stepRow;
        int currentCol = startCol + stepCol;

        while (currentRow != endRow || currentCol != endCol) {
            if (board.getPiece(currentRow, currentCol) != null) {
                return false;
            }
            currentRow += stepRow;
            currentCol += stepCol;
        }

        // проверяем, не пытается ли ладья захватить свою фигуру
        Piece target = board.getPiece(endRow, endCol);
        return target == null || !target.getColor().equals(getColor());
    }
}
