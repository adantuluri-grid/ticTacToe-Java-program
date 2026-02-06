package tictactoe;

import java.util.Scanner;
import java.util.Random;

public class Stage4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Input command: > ");
            String input = scanner.nextLine();
            String[] parts = input.trim().split("\\s+");

            if (parts[0].equals("exit")) break;

            if (parts[0].equals("start")) {
                if (parts.length != 3 || !isValid(parts[1]) || !isValid(parts[2])) {
                    System.out.println("Bad parameters!");
                    continue;
                }
                playGame(parts[1], parts[2], scanner);
            } else {
                System.out.println("Bad parameters!");
            }
        }
    }

    private static boolean isValid(String p) {
        return p.equals("user") || p.equals("easy") || p.equals("medium");
    }

    public static void playGame(String p1, String p2, Scanner scanner) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) board[i][j] = ' ';
        }

        printBoard(board);
        Random random = new Random();

        while (true) {
            if (makeMove(p1, 'X', 'O', board, scanner, random)) break;
            if (makeMove(p2, 'O', 'X', board, scanner, random)) break;
        }
    }

    public static boolean makeMove(String type, char symbol, char opponent, char[][] board, Scanner scanner, Random random) {
        if (type.equals("user")) {
            userMove(board, scanner, symbol);
        } else if (type.equals("easy")) {
            System.out.println("Making move level \"easy\"");
            easyMove(board, random, symbol);
        } else if (type.equals("medium")) {
            System.out.println("Making move level \"medium\"");
            mediumMove(board, random, symbol, opponent);
        }
        printBoard(board);
        return isGameOver(board);
    }

    public static void mediumMove(char[][] board, Random random, char self, char opponent) {
        // 1. Try to win
        if (tryCompleteLine(board, self, self)) return;
        // 2. Try to block
        if (tryCompleteLine(board, opponent, self)) return;
        // 3. Move randomly
        easyMove(board, random, self);
    }

    private static boolean tryCompleteLine(char[][] board, char targetSymbol, char fillSymbol) {
        int[][] lines = {
                {0,0, 0,1, 0,2}, {1,0, 1,1, 1,2}, {2,0, 2,1, 2,2},
                {0,0, 1,0, 2,0}, {0,1, 1,1, 2,1}, {0,2, 1,2, 2,2},
                {0,0, 1,1, 2,2}, {0,2, 1,1, 2,0}
        };

        for (int[] l : lines) {
            int count = 0;
            int emptyR = -1, emptyC = -1;
            for (int i = 0; i < 6; i += 2) {
                if (board[l[i]][l[i+1]] == targetSymbol) count++;
                else if (board[l[i]][l[i+1]] == ' ') {
                    emptyR = l[i];
                    emptyC = l[i+1];
                }
            }
            if (count == 2 && emptyR != -1) {
                board[emptyR][emptyC] = fillSymbol;
                return true;
            }
        }
        return false;
    }

    public static void easyMove(char[][] board, Random random, char symbol) {
        while (true) {
            int r = random.nextInt(3), c = random.nextInt(3);
            if (board[r][c] == ' ') {
                board[r][c] = symbol;
                break;
            }
        }
    }

    public static void userMove(char[][] board, Scanner scanner, char symbol) {
        while (true) {
            System.out.print("Enter the coordinates: > ");
            String input = scanner.nextLine();
            try {
                String[] p = input.trim().split("\\s+");
                int r = Integer.parseInt(p[0]) - 1;
                int c = Integer.parseInt(p[1]) - 1;
                if (r < 0 || r > 2 || c < 0 || c > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (board[r][c] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    board[r][c] = symbol;
                    break;
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("---------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) System.out.print(cell + " ");
            System.out.println("|");
        }
        System.out.println("---------");
    }

    // --- CHECKS GAME OVER STATUS ---
    public static boolean isGameOver(char[][] board) {
        String res = getResult(board);
        if (res.equals("Ongoing")) return false;
        System.out.println(res);
        return true;
    }

    public static String getResult(char[][] b) {
        if (check(b, 'X')) return "X wins";
        if (check(b, 'O')) return "O wins";
        for (char[] r : b) for (char c : r) if (c == ' ') return "Ongoing";
        return "Draw";
    }

    public static boolean check(char[][] b, char s) {
        for (int i = 0; i < 3; i++) {
            if (b[i][0] == s && b[i][1] == s && b[i][2] == s) return true;
            if (b[0][i] == s && b[1][i] == s && b[2][i] == s) return true;
        }
        return (b[0][0] == s && b[1][1] == s && b[2][2] == s) || (b[0][2] == s && b[1][1] == s && b[2][0] == s);
    }
}