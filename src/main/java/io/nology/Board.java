package io.nology;

// BOARD STATE

// 0: empty
// 1-8: number of adjacent bombs
// 9: bomb on this square

public class Board {
    int[] fullBoard;
    String[] revealedBoard;
    int width;

    public Board(int boardWidth) {
        this.width = boardWidth;
        this.fullBoard = new int[width * width];
        this.revealedBoard = new String[width * width];
        for (int i = 0; i < fullBoard.length; i++) {
            fullBoard[i] = 0;
        }
        for (int j = 0; j < revealedBoard.length; j++) {
            revealedBoard[j] = "0";
        }
    }

    private void addBomb() {
        int chosenSquare = (int) Math.floor(Math.random() * fullBoard.length);
        if (fullBoard[chosenSquare] != 9) {
            fullBoard[chosenSquare] = 9;
        }

    }

    private void incrementSurrounding() {
        // How do you find if a square's at the edge?

    }

    public void setRevealed(int cell) {
        revealedBoard[cell] = "1";
    }
}
