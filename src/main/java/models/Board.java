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

    /**
     * Инициализируем доску стандартной расстановкой фигур
     */
    private void initializeBoard() {
        // Расставляем пешки
        for (int col = 0; col < 8; col++) {
            board[1][col] = new Pawn("black"); // Черные пешки
            board[6][col] = new Pawn("white"); // Белые пешки
        }

        // Расставляем фигуры черных
        board[0][0] = new Rook("black");
        board[0][1] = new Knight("black");
        board[0][2] = new Bishop("black");
        board[0][3] = new Queen("black");
        board[0][4] = new King("black");
        board[0][5] = new Bishop("black");
        board[0][6] = new Knight("black");
        board[0][7] = new Rook("black");

        // Расставляем фигуры белых
        board[7][0] = new Rook("white");
        board[7][1] = new Knight("white");
        board[7][2] = new Bishop("white");
        board[7][3] = new Queen("white");
        board[7][4] = new King("white");
        board[7][5] = new Bishop("white");
        board[7][6] = new Knight("white");
        board[7][7] = new Rook("white");
    }

    public Piece getPiece(int row, int col){
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece){
        board[row][col] = piece;
    }
}
