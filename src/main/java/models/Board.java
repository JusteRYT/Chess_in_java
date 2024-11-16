package models;

import java.util.Locale;

/*
 * Представление шахматной доски в игре
 * Данный класс управляет инициализацией и состоянием доски
 */
public class Board {
    private final Piece[][] board;

    public Board() {
        // Инициализируем пустую доску размером 8х8
        board = new Piece[8][8];
    }

    /**
     * Инициализируем доску стандартной расстановкой фигур
     */
    public void initializeBoard() {
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

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    /**
     * Возвращает текстовое представление доски.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("  a b c d e f g h\n");
        for (int row = 0; row < 8; row++) {
            builder.append(8 - row).append(" "); // Левые координаты (8...1)
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                // Добавляем символ пустой клетки, если фигуры нет
                builder.append(piece == null ? ". " : getPieceSymbol(piece) + " ");
            }
            builder.append(8 - row).append("\n"); // Правые координаты
        }
        builder.append("  a b c d e f g h\n"); // Нижние координаты
        return builder.toString();
    }


    private String getPieceSymbol(Piece piece) {
        // Используем первую букву типа фигуры и цвет
        String type = piece.getClass().getSimpleName().substring(0, 1).toUpperCase();
        return piece.getColor().equals("white") ? type : type.toLowerCase();
    }

    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {

        //Проверяем, существует ли фигура на начальной клетке
        Piece piece = getPiece(startRow, startCol);
        if(piece == null) {
            System.out.println("На выбранной клетке нет фигуры.");
            return false;
        }

        //Проверяем, корректен ли ход
        if(!piece.isValidMove(startRow, startCol,endRow,endCol,this)){
            System.out.println("Недопустимый ход для фигуры: " + piece.getClass().getSimpleName());
            return false;
        }
        // Сохраняем текущее состояние для проверки шаха
        Piece targetPiece = getPiece(endRow, endCol);
        setPiece(endRow, endCol, piece);
        setPiece(startRow, startCol, null);

        // Проверяем, не будет ли король под шахом после хода
        if(isKingInCheck(piece.getColor())){
            // Отменяем ход
            setPiece(startRow, startCol, piece);
            setPiece(endRow, endCol, targetPiece);
            System.out.println("Ход оставляет короля под шахом!");
            return false;
        }

        return true;
    }

    /**
     * Проверяет, находится ли король определенного цвета под угрозой
     *
     * @param kingColor цвет короля ("white" или "black")
     * @return true, если король под угрозой
     */
    public boolean isKingInCheck(String kingColor){
        int kingRow = -1, kingCol = -1;

        // Ищем позицию короля
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if(piece instanceof King && piece.getColor().equals(kingColor)){
                    kingRow = row;
                    kingCol = col;
                    break;
                }
            }
        }

        // Если король не найден (ошибка в логике)
        if(kingRow == -1 || kingCol == -1){
            throw new IllegalStateException("Король цвета " + kingColor + " не найден!");
        }

        // Проверяем, может ли любая фигура противника атаковать короля
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if(piece != null && !piece.getColor().equals(kingColor)){
                    if(piece.isValidMove(row,col,kingRow,kingCol,this)){
                        return true; //Король под атакой
                    }
                }
            }
        }
        return false; // Король в безопасности
    }
}
