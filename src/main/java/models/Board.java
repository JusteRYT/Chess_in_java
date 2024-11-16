package models;

/*
 * Представление шахматной доски в игре
 * Данный класс управляет инициализацией и состоянием доски
 */
public class Board {
    private Piece[][] board;

    public Board() {
        // Инициализируем пустую доску размером 8х8
        board = new Piece[8][8];
    }

    public Piece getPiece(int row, int col){
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece){
        board[row][col] = piece;
    }
}
