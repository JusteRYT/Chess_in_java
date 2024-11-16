import models.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.initializeBoard();
        System.out.println("Шахматная доска инициализирована!");
        System.out.println(board);

        // Пробуем сделать ход Пешкой
        System.out.println("Ход ладьей (a2 -> a4):");
        if (board.movePiece(6, 0, 4, 0)) { // a1 -> a4
            System.out.println("Ход успешен!");
        } else {
            System.out.println("Ход не выполнен.");
        }
        System.out.println(board);
        // Пробуем сделать ход ладьей
        System.out.println("Ход ладьей (a1 -> a3):");
        if (board.movePiece(7, 0, 5, 0)) { // a1 -> a4
            System.out.println("Ход успешен!");
        } else {
            System.out.println("Ход не выполнен.");
        }
        System.out.println(board);


        // Пробуем сделать ход Пешкой
        System.out.println("Ход пеш (b2 -> b4):");
        if (board.movePiece(6, 1, 4, 1)) { // a1 -> a4
            System.out.println("Ход успешен!");
        } else {
            System.out.println("Ход не выполнен.");
        }
        System.out.println(board);
        // Пробуем сделать ход слоном
        System.out.println("Ход слоном (c1 -> f4):");
        if (board.movePiece(7, 2, 6, 1)) { // c1 -> f4
            System.out.println("Ход успешен!");
        } else {
            System.out.println("Ход не выполнен.");
        }
        System.out.println(board);

        // Пробуем сделать ход конем
        System.out.println("Ход конем (b1 -> c3):");
        if (board.movePiece(7, 1, 5, 2)) { // b1 -> c3
            System.out.println("Ход успешен!");
        } else {
            System.out.println("Ход не выполнен.");
        }
        System.out.println(board);
    }
}
