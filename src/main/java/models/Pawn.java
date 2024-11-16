package models;

/**
 * Пешка.
 * Реализует определенные правила перемещения
 */
public class Pawn extends Piece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Board board) {
        int direction = getColor().equals("white") ? -1 : 1; // Направление хода пешки
        int startRowWhite = 6; // Начальная строка для белых пешек
        int startRowBlack = 1; // Начальная строка для чёрных пешек

        // Обычный ход на одну клетку вперед
        if (endRow == startRow + direction && startCol == endCol && board.getPiece(endRow, endCol) == null) {
            return true;
        }

        // Ход на две клетки вперед из начального положения
        if (startRow == (getColor().equals("white") ? startRowWhite : startRowBlack)
                && endRow == startRow + 2 * direction && startCol == endCol
                && board.getPiece(endRow, endCol) == null
                && board.getPiece(startRow + direction, startCol) == null) {
            return true;
        }

        // Взятие фигуры противника
        if (endRow == startRow + direction && Math.abs(endCol - startCol) == 1
                && board.getPiece(endRow, endCol) != null
                && !board.getPiece(endRow, endCol).getColor().equals(getColor())) {
            return true;
        }

        return false;
    }
}
