package io.nology;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    int minesRemaining;
    Scanner inputScanner = new Scanner(System.in);
    Board newBoard;
    int boardWidth;
    List<Integer> checkList;

    public void startup() {
        System.out.println("Enter 'S' to start a game, 'H' for help, or 'X' to exit");
        handleInput(inputScanner.next());

    }

    public void handleInput(String input) {
        String lowerInput = input.toLowerCase();

        if (minesRemaining > 0 && lowerInput.length() > 1) {
            Pattern inputPattern = Pattern.compile("^[mbc][a-z]\\d\\d?");
            Matcher matcher = inputPattern.matcher(lowerInput);
            if (matcher.matches() && lowerInput.charAt(0) == 'c') {
                int index = getIndexFromCoordinate(lowerInput);
                checkCell(index);
            } else if (matcher.matches() && (lowerInput.charAt(0) == 'b' || lowerInput.charAt(0) == 'm')) {
                int index = getIndexFromCoordinate(lowerInput);
                markCell(index);
            }
        }
        if ("help".equals(lowerInput.toLowerCase().trim())) {
            printHelp();
        }

        if (lowerInput.length() == 1) {
            switch (lowerInput) {
                case "s":
                    beginGame();
                    break;
                case "x":
                    System.out.println("Thank you for playing!");
                    System.exit(0);
                    break;
                case "h":
                    printHelpShort();
                    if (minesRemaining > 0) {
                        gameLoop(newBoard);
                    } else {
                        startup();
                    }
                default:
                    System.out.println("Unrecognised input, please try again.");
                    handleInput(inputScanner.next());
                    break;
            }
        }
    }

    public void beginGame() {
        System.out.println(
                "Enter a width for your board between 1 and 25. This also determines the number of mines to find.");
        System.out.println("(Easy = 5, Medium = 10, Hard = 20)");
        int inputWidth = 0;
        while (inputWidth < 1 || inputWidth > 25) {
            inputWidth = inputScanner.nextInt();
            if (inputWidth < 1 || inputWidth > 25) {
                System.out.println("Invalid number entered, try again.");
            }
        }
        newBoard = new Board(inputWidth);
        boardWidth = inputWidth;
        minesRemaining = boardWidth;
        System.out.printf("There are %d mines to find.\n", minesRemaining);
        gameLoop(newBoard);
    }

    public void gameLoop(Board board) {
        while (minesRemaining > 0) {
            BoardPrinter.printCurrentBoard(board);
            handleInput(inputScanner.next());
        }
        gameVictory();
    }

    public void checkCell(int index) {
        // System.out.printf("Cell %d checked!\n", index);
        if (newBoard.fullBoard[index] == 9) {
            System.out.println("Yep, that's a mine.");
            gameOver();
        }
        newBoard.revealedBoard[index] = "1";
        if (newBoard.fullBoard[index] == 0) {
            newBoard.checkAdjacentCellsEmpty(index);
        }
    }

    public void markCell(int index) {
        // disarming mines rather than just marking prevents player from being
        // able to brute force the game
        if (newBoard.fullBoard[index] == 9) {
            minesRemaining--;
            System.out.printf("You disarmed a mine! %d remaining.\n", minesRemaining);
            newBoard.revealedBoard[index] = "#";

        } else {
            System.out.println("That wasn't a mine, so why are you blowing up? One of life's great mysteries.");
            gameOver();
        }

    }

    public void printHelp() {
        System.out.println("Your objective is to correctly mark all mines on the board.");
        System.out.println("The number of mines on the board is equal to the width/height of the grid.");
        System.out.println("To check a cell, enter the character 'C' followed by the cell you wish to check.");
        System.out.println("For example, 'CA4' or 'cb8'. All inputs are case insensitive.");
        System.out.println(
                "To mark a cell that contains a mine, enter the character 'M' or 'B' before the cell.");
        System.out.println("For example, 'Ba1'.");
        System.out.println("Successfully mark all mines to win the game!");
        gameLoop(newBoard);
    }

    public void printHelpShort() {
        System.out.println("Check cells in the input format 'Ca1'. Mark mines in the format 'Ba1'.");
        System.out.println("S: starts new game");
        System.out.println("H: shows this information");
        System.out.println("Enter the full word 'help' for detailed instructions.");
        System.out.println("X: exits the game");
        System.out.println("All inputs are case insensitive.");
        gameLoop(newBoard);
    }

    public void gameVictory() {
        BoardPrinter.printCurrentBoard(newBoard);
        System.out.println("Congratulations, you won!");
        replayPrompt();
    }

    public void replayPrompt() {
        System.out.println("Would you like to play again? (y/n)");
        String input = inputScanner.next().toLowerCase();
        switch (input) {
            case "y":
                startup();
            case "n":
                System.out.println("Thank you for playing!");
                System.exit(0);
            default:
                System.out.println("Sorry, didn't quite catch that.");
                replayPrompt();
        }
    }

    public void gameOver() {
        System.out.println("BOOM!");
        BoardPrinter.printCurrentBoard(newBoard);
        System.out.println("Game over :(");
        replayPrompt();
    }

    public int getIndexFromCoordinate(String input) {
        // get char code of letter
        char columnLetter = input.charAt(1);
        // number from string
        Integer row = Integer.parseInt(input.substring(2));
        // subtract char code of 'a' (97) to get difference between 'a' and letter
        int column = ((int) columnLetter) - 97;
        // row number * row width + above should equal cell index
        int index = ((row - 1) * boardWidth) + column;
        // if index < 0 || index > board.length throw error
        return index;
    }
}
