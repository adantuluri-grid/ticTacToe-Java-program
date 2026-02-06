package tictactoe;

import java.util.Scanner;
import java.util.Random;

public class Stage2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        printBoard(board);

        while (true) {
            userMove(board, scanner);
            printBoard(board);
            if (isGameOver(board)) break;

            System.out.println("Making move level \"easy\"");
            aiMove(board, random);
            printBoard(board);
            if (isGameOver(board)) break;
        }
    }

    public static void userMove(char[][] board, Scanner scanner) {
        while (true) {
            System.out.print("Enter the coordinates: > ");
            String input = scanner.nextLine();
            String[] parts = input.trim().split("\\s+");

            if(parts.length < 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            boolean isNumeric = true;
            for (String p : parts) {
                for (int i = 0; i < p.length(); i++) {
                    if (p.charAt(i) < '0' || p.charAt(i) > '9') isNumeric = false;
                }
            }

            if (!isNumeric) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);

            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (board[row - 1][col - 1] != ' ') {
                System.out.println("The cell is occupied! Choose another one!");
            } else {
                board[row - 1][col - 1] = 'X';
                break;
            }
        }
    }

    public static void aiMove(char[][] board, Random random) {
        while (true) {
            int r = random.nextInt(3);
            int c = random.nextInt(3);
            if (board[r][c] == ' ') {
                board[r][c] = 'O';
                break;
            }
        }
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

    // --- CHECKS GAME OVER STATUS ---
    public static boolean isGameOver(char[][] board) {
        String state = getGameState(board);
        if (state.equals("Game not finished")) {
            return false;
        } else {
            System.out.println(state);
            return true;
        }
    }

    public static boolean checkWin(char[][] b, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (b[i][0] == symbol && b[i][1] == symbol && b[i][2] == symbol) return true;
            if (b[0][i] == symbol && b[1][i] == symbol && b[2][i] == symbol) return true;
        }
        return (b[0][0] == symbol && b[1][1] == symbol && b[2][2] == symbol) ||
                (b[0][2] == symbol && b[1][1] == symbol && b[2][0] == symbol);
    }
    // --- CHECKS GAME STATE ---
    public static String getGameState(char[][] b) {
        boolean xWins = checkWin(b, 'X');
        boolean oWins = checkWin(b, 'O');
        boolean hasEmpty = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] == ' ') hasEmpty = true;
            }
        }

        if (xWins) return "X wins";
        if (oWins) return "O wins";
        if (!hasEmpty) return "Draw";
        return "Game not finished";
    }


}