import models.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.initializeBoard();
        System.out.println("Шахматная доска инициализирована!");
        System.out.println(board);
    }
}
