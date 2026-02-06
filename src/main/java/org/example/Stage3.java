import java.util.Scanner;
import java.util.Random;


public class Stage3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Input command: > ");
            String input = scanner.nextLine();
            String[] parts = input.trim().split("\\s+");

            if (parts.length == 0 || parts[0].isEmpty()) {
                continue;
            }

            if (parts[0].equals("exit")) {
                break;
            }

            if (parts[0].equals("start")) {
                if (parts.length != 3) {
                    System.out.println("Bad parameters!");
                    continue;
                }

                String playerX = parts[1];
                String playerO = parts[2];

                if (isValidType(playerX) && isValidType(playerO)) {
                    playGame(playerX, playerO, scanner);
                } else {
                    System.out.println("Bad parameters!");
                }
            } else {
                System.out.println("Bad parameters!");
            }
        }
    }

    // --- CHECKS INPUT VALIDITY ---
    public static boolean isValidType(String type) {
        return type.equals("user") || type.equals("easy");
    }

    public static void playGame(String p1Type, String p2Type, Scanner scanner) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        printBoard(board);
        Random random = new Random();

        while (true) {
            executeMove(p1Type, 'X', board, scanner, random);       //X's turn
            printBoard(board);
            if (isGameOver(board)) break;

            executeMove(p2Type, 'O', board, scanner, random);      //O's turn
            printBoard(board);
            if (isGameOver(board)) break;
        }
    }

    public static void executeMove(String type, char symbol, char[][] board, Scanner scanner, Random random) {
        if (type.equals("user")) {
            userMove(board, scanner, symbol);
        } else {
            System.out.println("Making move level \"easy\"");
            aiMove(board, random, symbol);
        }
    }

    public static void userMove(char[][] board, Scanner scanner, char symbol) {
        while (true) {
            System.out.print("Enter the coordinates: > ");
            String input = scanner.nextLine();
            String[] parts = input.trim().split("\\s+");

            if (parts.length < 2) {
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
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                board[row - 1][col - 1] = symbol;
                break;
            }
        }
    }

    public static void aiMove(char[][] board, Random random, char symbol) {
        while (true) {
            int r = random.nextInt(3);
            int c = random.nextInt(3);
            if (board[r][c] == ' ') {
                board[r][c] = symbol;
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

    // --- CHECKS GAME STATE ---
    public static String getGameState(char[][] b) {
        if (checkWin(b, 'X')) return "X wins";
        if (checkWin(b, 'O')) return "O wins";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] == ' ') return "Game not finished";
            }
        }
        return "Draw";
    }

    public static boolean checkWin(char[][] b, char s) {
        for (int i = 0; i < 3; i++) {
            if (b[i][0] == s && b[i][1] == s && b[i][2] == s) return true;
            if (b[0][i] == s && b[1][i] == s && b[2][i] == s) return true;
        }
        return (b[0][0] == s && b[1][1] == s && b[2][2] == s) ||
                (b[0][2] == s && b[1][1] == s && b[2][0] == s);
    }
}