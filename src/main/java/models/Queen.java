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
        // Ферзь может двигаться как ладья или как слон
        boolean isRookMove = startRow == endRow || startCol == endCol;
        boolean isBishopMove = Math.abs(startRow - endRow) == Math.abs(startCol - endCol);

        if(!isRookMove && !isBishopMove) {
            return false;
        }

        // Проверяем путь для ладьи или слона
        int stepRow = Integer.compare(endRow, startRow);
        int stepCol = Integer.compare(endCol, startCol);
        int currentRow = startRow + stepRow;
        int currentCol = startCol + stepCol;

        while (currentRow != endRow || currentCol != endCol) {
            if(board.getPiece(currentRow, currentCol) != null) {
                return false;
            }
            currentRow += stepRow;
            currentCol += stepCol;
        }

        // Проверяем, не пытается ли ферзь захватить свою фигуру
        Piece target = board.getPiece(endRow, endCol);
        return target == null || !target.getColor().equals(getColor());
    }
}
