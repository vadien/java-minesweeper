package io.nology;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Board newBoard = new Board(10);
        newBoard.setRevealed(7);
        newBoard.setRevealed(54);

        BoardPrinter.printCurrentBoard(newBoard);
    }

}
