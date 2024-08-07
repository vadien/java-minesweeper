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

        for (int i = 0; i < 10; i++) {
            addBomb();
        }
    }

    private void addBomb() {
        int chosenCell = (int) Math.floor(Math.random() * fullBoard.length);
        if (fullBoard[chosenCell] == 9) {
            return;
        }
        fullBoard[chosenCell] = 9;

        // top row
        int cellAbove = chosenCell - width;
        if ((cellAbove > 0) && fullBoard[cellAbove] != 9) {
            fullBoard[cellAbove] += 1;
        }

        // bottom row
        int cellBelow = chosenCell + width;
        if ((cellBelow < fullBoard.length) && fullBoard[cellBelow] != 9) {
            fullBoard[cellBelow] += 1;
        }

        // left column
        int cellLeft = chosenCell - 1;
        if ((chosenCell % width != 0) && fullBoard[cellLeft] != 9) {
            fullBoard[cellLeft] += 1;
        }

        // right column
        int cellRight = chosenCell + 1;
        if ((chosenCell % width != 9) && fullBoard[cellRight] != 9) {
            fullBoard[cellRight] += 1;
        }

        // cell above left
        if (cellAbove > 0 && chosenCell % width != 0 && fullBoard[cellAbove - 1] != 9) {
            fullBoard[cellAbove - 1] += 1;
        }

        // cell above right
        if (cellAbove > 0 && chosenCell % width != 9 && fullBoard[cellAbove + 1] != 9) {
            fullBoard[cellAbove + 1] += 1;
        }

        // cell below left
        if (cellBelow < fullBoard.length && chosenCell % width != 0 && fullBoard[cellBelow - 1] != 9) {
            fullBoard[cellBelow - 1] += 1;
        }

        // cell below right
        if (cellBelow < fullBoard.length && chosenCell % width != 9 && fullBoard[cellBelow + 1] != 9) {
            fullBoard[cellBelow + 1] += 1;
        }
    }

    private void incrementSurrounding() {

    }

    public void setRevealed(int cell) {
        revealedBoard[cell] = "1";
    }
}
