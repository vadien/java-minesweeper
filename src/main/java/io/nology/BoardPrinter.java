package io.nology;

public class BoardPrinter {
    public static void testPrint() {
        System.out.println("   A B C D E F G H I J");
        System.out.println("1  X X X X X X X X X X");
        System.out.println("2  X X X X X X X X X X");
        System.out.println("3  X X X X X X X X X X");
        System.out.println("4  X X X X X X X X X X");
        System.out.println("5  X X X X X X X X X X");
        System.out.println("6  X X X X X X X X X X");
        System.out.println("7  X X X X X X X X X X");
        System.out.println("8  X X X X X X X X X X");
        System.out.println("9  X X X X X X X X X X");
        System.out.println("10 X X X X X X X X X X");

    }

    public static void printCurrentBoard(Board board) {
        // print label row for columns
        String header = "   ";
        for (int i = 65; i < (board.width + 65); i++) {
            header += (char) (i);
            header += " ";
        }
        System.out.println(header);
        // print each row
        for (Integer i = 1; i <= board.width; i++) {
            String currentRow = i.toString();
            if (i < 10) {
                currentRow += "  ";
            } else {
                currentRow += " ";
            }
            ;
            for (int j = (0 + ((i - 1) * board.width)); j < (board.width * i); j++) {
                if (board.revealedBoard[j] == "0") {
                    currentRow += "X ";

                } else {
                    currentRow += board.fullBoard[j];
                    currentRow += " ";
                }
            }
            System.out.println(currentRow);
        }
    }

    public static void printFullRevealedBoard(Board board) {
        // print label row for columns
        String header = "   ";
        for (int i = 65; i < (board.width + 65); i++) {
            header += (char) (i);
            header += " ";
        }
        System.out.println(header);
        // print each row
        for (Integer i = 1; i <= board.width; i++) {
            String currentRow = i.toString();
            if (i < 10) {
                currentRow += "  ";
            } else {
                currentRow += " ";
            }
            ;
            for (int j = (0 + ((i - 1) * board.width)); j < (board.width * i); j++) {
                currentRow += board.fullBoard[j];
                currentRow += " ";
            }
            System.out.println(currentRow);
        }
    }
}
