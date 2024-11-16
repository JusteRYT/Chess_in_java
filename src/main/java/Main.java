import models.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.initializeBoard();
        System.out.println("Шахматная доска инициализирована!");
        System.out.println(board);

        System.out.println("Ход пешкой (d7 -> d5)");
        if(board.movePiece(1,3,3,3)){
            System.out.println("Ход выполнен!");
        } else {
            System.out.println("Ход не выполнен!");
        }
        System.out.println(board);

        System.out.println("Ход пешкой (c2 -> c4)");
        if(board.movePiece(6,2,4,2)){
            System.out.println("Ход выполнен!");
        } else {
            System.out.println("Ход не выполнен!");
        }
        System.out.println(board);

        System.out.println("Ход королевой (d1 -> a4)");
        if(board.movePiece(7,3,4,0)){
            System.out.println("Ход выполнен!");
        } else {
            System.out.println("Ход не выполнен!");
        }
        System.out.println("Проверяем шах черному королю:");
        if (board.isKingInCheck("black")){
            System.out.println("Черный король под шахом!");
        } else {
            System.out.println("Черный король в безопасности");
        }
        System.out.println(board);
    }
}
