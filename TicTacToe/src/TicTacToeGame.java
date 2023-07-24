import java.util.Scanner;

public class TicTacToeGame {
    private char[][] board;
    private char currentPlayerSymbol;
    private boolean gameOver;

    public TicTacToeGame() {
        board = new char[3][3];
        currentPlayerSymbol = 'X';
        initializeBoard();
        gameOver = false;
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            return false;
        }
        board[row][col] = currentPlayerSymbol;

        if (checkWinningStrategy(row, col) || checkCornersWinningStrategy()) {
            gameOver = true;
        } else {
            currentPlayerSymbol = (currentPlayerSymbol == 'X') ? 'O' : 'X';
        }
        return true;
    }

    private boolean checkWinningStrategy(int row, int col) {
        char symbol = board[row][col];

        // Check row and column for winning strategy
        boolean rowWin = true;
        boolean colWin = true;
        for (int i = 0; i < 3; i++) {
            if (board[row][i] != symbol) {
                rowWin = false;
            }
            if (board[i][col] != symbol) {
                colWin = false;
            }
        }
        if (rowWin || colWin) {
            return true;
        }

        // Check diagonal and anti-diagonal for winning strategy
        if (row == col) {
            boolean diagonalWin = true;
            for (int i = 0; i < 3; i++) {
                if (board[i][i] != symbol) {
                    diagonalWin = false;
                    break;
                }
            }
            if (diagonalWin) {
                return true;
            }
        }
        if (row + col == 2) {
            boolean antiDiagonalWin = true;
            for (int i = 0; i < 3; i++) {
                if (board[i][2 - i] != symbol) {
                    antiDiagonalWin = false;
                    break;
                }
            }
            if (antiDiagonalWin) {
                return true;
            }
        }

        return false;
    }
    private boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // There is an empty cell, game is not a draw yet
                }
            }
        }
        return true; // All cells are filled, game is a draw
    }

    private boolean checkCornersWinningStrategy() {
        char symbol = board[0][0];
        if (symbol != ' ' && board[0][2] == symbol && board[2][0] == symbol && board[2][2] == symbol) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");
        while (!game.isGameOver()) {
            game.printBoard();
            if(!game.checkDraw()) {
                System.out.print("Player " + game.currentPlayerSymbol + ", enter row number (0, 1, or 2): ");
                int row = scanner.nextInt();
                System.out.print("Player " + game.currentPlayerSymbol + ", enter column number (0, 1, or 2): ");
                int col = scanner.nextInt();
                if (!game.makeMove(row, col)) {
                    System.out.println("Invalid move! Try again.");
                }
            }else{
                break;
            }
        }
        game.printBoard();
        if (game.checkDraw()) {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Player " + game.currentPlayerSymbol + " wins!");
        }
        scanner.close();
    }
}
