package tictactoe;

import java.util.Scanner;

public class Stage1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the cells: > ");
        String input = scanner.nextLine();

        char[][] board = new char[3][3];
        int xCount = 0;
        int oCount = 0;

        for (int i = 0; i < 9; i++) {
            char symbol = input.charAt(i);
            board[i / 3][i % 3] = (symbol == '_' ? ' ' : symbol);
            if (symbol == 'X') xCount++;
            if (symbol == 'O') oCount++;
        }

        printBoard(board);

        int row = 0;
        int col = 0;

        while (true) {
            System.out.print("Enter the coordinates: > ");
            String line = scanner.nextLine();
            String[] parts = line.trim().split("\\s+");

            boolean isNumeric = true;
            for (int i = 0; i < parts.length; i++) {
                String p = parts[i];
                if (p.isEmpty()) continue;
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) < '0' || p.charAt(j) > '9') {
                        isNumeric = false;
                        break;
                    }
                }
            }

            if (!isNumeric || parts[0].isEmpty()) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (parts.length < 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            row = Integer.parseInt(parts[0]);
            col = Integer.parseInt(parts[1]);

            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (board[row - 1][col - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            break;
        }

        board[row - 1][col - 1] = (xCount <= oCount) ? 'X' : 'O';
        printBoard(board);
        checkGameState(board);
    }

    public static void printBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void checkGameState(char[][] b) {
        boolean xWins = false;
        boolean oWins = false;
        boolean hasEmpty = false;

        // --- CHECKS ROWS AND COLUMNS FOR THREE IN ROW ---
        for (int i = 0; i < 3; i++) {
            if (b[i][0] != ' ' && b[i][0] == b[i][1] && b[i][0] == b[i][2]) {
                if (b[i][0] == 'X') xWins = true; else oWins = true;
            }
            if (b[0][i] != ' ' && b[0][i] == b[1][i] && b[0][i] == b[2][i]) {
                if (b[0][i] == 'X') xWins = true; else oWins = true;
            }
        }

        // --- CHECKS BOTH DIAGONALS ---
        if (b[1][1] != ' ') {
            if ((b[0][0] == b[1][1] && b[0][0] == b[2][2]) || (b[0][2] == b[1][1] && b[0][2] == b[2][0])) {
                if (b[1][1] == 'X') xWins = true; else oWins = true;
            }
        }

        // --- CHECKS FOR EMPTY CELLS ---
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] == ' ') hasEmpty = true;
            }
        }

        if (xWins) System.out.println("X wins");
        else if (oWins) System.out.println("O wins");
        else if (hasEmpty) System.out.println("Game not finished");
        else System.out.println("Draw");
    }
}