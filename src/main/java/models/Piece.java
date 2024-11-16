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

    /**
     * Проверяет, допустим ли ход для данной фигуры.
     *
     * @param startRow Начальная строка
     * @param startCol Начальный столбец
     * @param endRow Конечная строка
     * @param endCol Конечный столбец
     * @param board Текущее состояние доски
     * @return true, если ход допустим
     */
    public abstract boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Board board);
}
