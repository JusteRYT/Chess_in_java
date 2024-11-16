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
        // Слон движется по диагонали
        if (Math.abs(startRow - endRow) != Math.abs(startCol - endCol)) {
            return false;
        }

        // Проверяем, что между начальной и конечной клетками нет других фигур
        int stepRow = Integer.compare(endRow, startRow);
        int stepCol = Integer.compare(endCol, startCol);
        int currentRow = startRow + stepRow;
        int currentCol = startCol + stepCol;

        while (currentRow != endRow || currentCol != endCol) {
            if (board.getPiece(currentRow, currentCol) != null) {
                return false; // Фигура на пути
            }
            currentRow += stepRow;
            currentCol += stepCol;
        }

        // Проверяем, не пытается ли слон захватить свою фигуру
        Piece target = board.getPiece(endRow, endCol);
        return target == null || !target.getColor().equals(getColor());
    }
}
