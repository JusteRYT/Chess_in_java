import models.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println("Шахматная доска инициализирована!");

        // Тестовый вывод о состоянии доски
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                System.out.println((board.getPiece(row, col) == null ? "." : "X") + " ");
            }
            System.out.println();
        }
    }
}
