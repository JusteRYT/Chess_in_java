import models.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.initializeBoard();
        System.out.println("Шахматная доска инициализирована!");
        System.out.println(board);

        System.out.println("Ход пешкой (e2 -> e4):");
        if(board.movePiece(6,4,4,4)){
            System.out.println("Ход успешен!");
        } else {
            System.out.println("Ход не выполнен.");
        }
        System.out.println(board);
    }
}
