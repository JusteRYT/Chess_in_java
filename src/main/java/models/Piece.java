package models;

/**
 * Представление шахматной доски.
 * Сохраняет тип, цвет и основные характеристики фигуры
 */
public abstract class Piece {
    private final String color;

    public Piece(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    public abstract boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Board board);
}
