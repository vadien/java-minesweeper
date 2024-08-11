package io.nology;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Minesweeper!");
        System.out.println("Correctly mark all mines on the board to win.");
        System.out.println("Check the instructions before you get started!");
        // System.out.println("Hello World!");
        // Board newBoard = new Board(10);
        // newBoard.setRevealed(7);
        // newBoard.setRevealed(54);

        // BoardPrinter.printFullRevealedBoard(newBoard);
        Game newGame = new Game();
        newGame.startup();
    }

}
