package io.nology;

public class Board {
    int[] fullBoard;
    String[] revealedBoard;
    int width;
    int minesRemaining;
    // String[] winCondition; // TODO: match to revealedBoard as victory

    public Board(int boardWidth) {
        System.out.println("Generating board...");
        this.width = boardWidth;
        this.fullBoard = new int[width * width];
        this.revealedBoard = new String[width * width];
        for (int i = 0; i < fullBoard.length; i++) {
            fullBoard[i] = 0;
        }
        for (int j = 0; j < revealedBoard.length; j++) {
            revealedBoard[j] = "0";
        }

        while (minesRemaining < boardWidth) {
            if (addBomb()) {
                minesRemaining++;
            }
        }
    }

    private boolean addBomb() {
        int chosenCell = (int) Math.floor(Math.random() * fullBoard.length);
        if (fullBoard[chosenCell] == 9) {
            return false;
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
        if ((chosenCell % width != (width - 1)) && fullBoard[cellRight] != 9) {
            fullBoard[cellRight] += 1;
        }

        // cell above left
        if (cellAbove > 0 && chosenCell % width != 0 && fullBoard[cellAbove - 1] != 9) {
            fullBoard[cellAbove - 1] += 1;
        }

        // cell above right
        if (cellAbove > 0 && chosenCell % width != (width - 1) && fullBoard[cellAbove + 1] != 9) {
            fullBoard[cellAbove + 1] += 1;
        }

        // cell below left
        if (cellBelow < fullBoard.length && chosenCell % width != 0 && fullBoard[cellBelow - 1] != 9) {
            fullBoard[cellBelow - 1] += 1;
        }

        // cell below right
        if (cellBelow < fullBoard.length && chosenCell % width != (width - 1) && fullBoard[cellBelow + 1] != 9) {
            fullBoard[cellBelow + 1] += 1;
        }

        return true;
    }

    public void checkAdjacentCellsEmpty(int index) {

        // top row
        int cellAbove = index - width;
        if ((cellAbove > 0) && fullBoard[cellAbove] != 9) {
            if (fullBoard[cellAbove] == 0 && revealedBoard[cellAbove] == "0") {
                revealedBoard[cellAbove] = "1";
                checkAdjacentCellsEmpty(cellAbove);
            }
            revealedBoard[cellAbove] = "1";
        }

        // bottom row
        int cellBelow = index + width;
        if ((cellBelow < fullBoard.length) && fullBoard[cellBelow] != 9) {
            if (fullBoard[cellBelow] == 0 && revealedBoard[cellBelow] == "0") {
                revealedBoard[cellBelow] = "1";
                checkAdjacentCellsEmpty(cellBelow);
            }
            revealedBoard[cellBelow] = "1";
        }

        // left column
        int cellLeft = index - 1;
        if ((index % width != 0) && fullBoard[cellLeft] != 9) {
            if (fullBoard[cellLeft] == 0 && revealedBoard[cellLeft] == "0") {
                revealedBoard[cellLeft] = "1";
                checkAdjacentCellsEmpty(cellLeft);
            }
            revealedBoard[cellLeft] = "1";
        }

        // right column
        int cellRight = index + 1;
        if ((index % width != (width - 1)) && fullBoard[cellRight] != 9) {
            if (fullBoard[cellRight] == 0 && revealedBoard[cellRight] == "0") {
                revealedBoard[cellRight] = "1";
                checkAdjacentCellsEmpty(cellRight);
            }
            revealedBoard[cellRight] = "1";
        }

        // cell above left
        if (cellAbove > 0 && index % width != 0 && fullBoard[cellAbove - 1] != 9) {
            if (fullBoard[cellAbove - 1] == 0 && revealedBoard[cellAbove - 1] == "0") {
                revealedBoard[cellAbove - 1] = "1";
                checkAdjacentCellsEmpty(cellAbove - 1);
            }
            revealedBoard[cellAbove - 1] = "1";
        }

        // cell above right
        if (cellAbove > 0 && index % width != (width - 1) && fullBoard[cellAbove + 1] != 9) {
            if (fullBoard[cellAbove + 1] == 0 && revealedBoard[cellAbove + 1] == "0") {
                revealedBoard[cellAbove + 1] = "1";
                checkAdjacentCellsEmpty(cellAbove + 1);
            }
            revealedBoard[cellAbove + 1] = "1";
        }

        // cell below left
        if (cellBelow < fullBoard.length && index % width != 0 && fullBoard[cellBelow - 1] != 9) {
            if (fullBoard[cellBelow - 1] == 0 && revealedBoard[cellBelow - 1] == "0") {
                revealedBoard[cellBelow - 1] = "1";
                checkAdjacentCellsEmpty(cellBelow - 1);
            }
            revealedBoard[cellBelow - 1] = "1";
        }

        // cell below right
        if (cellBelow < fullBoard.length && index % width != (width - 1) && fullBoard[cellBelow + 1] != 9) {
            if (fullBoard[cellBelow + 1] == 0 && revealedBoard[cellBelow + 1] == "0") {
                revealedBoard[cellBelow + 1] = "1";
                checkAdjacentCellsEmpty(cellBelow + 1);
            }
            revealedBoard[cellBelow + 1] = "1";
        }
    }

    public void setRevealed(int cell) {
        revealedBoard[cell] = "1";
    }
}
