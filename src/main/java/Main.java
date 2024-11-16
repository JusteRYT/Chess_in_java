import models.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.initializeBoard();
        System.out.println("Шахматная доска инициализирована!");
        System.out.println(board);

        System.out.println("Ход пешкой (e2 -> e4)");
        if(board.movePiece(6,4,4,4)){
            System.out.println("Ход выполнен!");
        } else {
            System.out.println("Ход не выполнен!");
        }
        System.out.println(board);

        System.out.println("Ход пешкой (с2 -> c4");
        if(board.movePiece(6,2,4,2)){
            System.out.println("Ход выполнен!");
        } else {
            System.out.println("Ход не выполнен!");
        }
        System.out.println(board);

        System.out.println("Ход королем (e1 -> e2");
        if(board.movePiece(7,4,6,4)){
            System.out.println("Ход выполнен!");
        } else {
            System.out.println("Ход не выполнен!");
        }
        System.out.println(board);

        System.out.println("Ход ферзем (d7 -> a4");
        if(board.movePiece(7, 3, 4,0)){
            System.out.println("Ход выполнен!");
        } else {
            System.out.println("Ход не выполнен!");
        }
        System.out.println(board);
    }
}
