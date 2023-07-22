package model;

public class Board {
    public int boardSize;
    public PlayerPiece[][] board;


    public Board(int boardSize){
        this.boardSize = boardSize;
        initializeBoard(boardSize);
    }

    private void initializeBoard(int boardSize) {
        board = new PlayerPiece[boardSize][boardSize];
    }

    public void printBoardStatus(){
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                //System.out.print(board[i][j] + " ");
                PlayerPiece playerPiece = (PlayerPiece) board[i][j];
                //System.out.println("hello" + " ");
                if(playerPiece != null){
                    System.out.print(playerPiece.getPieceType() + "  ");
                }else{
                    System.out.print("__ ");
                }

            }
            System.out.println("");
        }
    }

    public boolean rowColumnDiagonalMatch(){

        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int N = board.length;

        // Check main diagonal
        PlayerPiece mainDiagonalFirst = board[0][0];
        boolean mainDiagonalEqual = true;
        for (int i = 1; i < N; i++) {
            if (board[i][i] != mainDiagonalFirst) {
                mainDiagonalEqual = false;
                break;
            }
        }
        if (mainDiagonalEqual) {
            return true;
        }

        // Check anti-diagonal
        PlayerPiece antiDiagonalFirst = board[0][N - 1];
        boolean antiDiagonalEqual = true;
        for (int i = 1; i < N; i++) {
            if (board[i][N - 1 - i] != antiDiagonalFirst) {
                antiDiagonalEqual = false;
                break;
            }
        }
        if (antiDiagonalEqual) {
            return true;
        }

        // Check rows
        for (int i = 0; i < N; i++) {
            boolean rowEqual = true;
            PlayerPiece rowFirst = board[i][0];
            for (int j = 1; j < N; j++) {
                if (board[i][j] != rowFirst) {
                    rowEqual = false;
                    break;
                }
            }
            if (rowEqual) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < N; j++) {
            boolean colEqual = true;
            PlayerPiece colFirst = board[0][j];
            for (int i = 1; i < N; i++) {
                if (board[i][j] != colFirst) {
                    colEqual = false;
                    break;
                }
            }
            if (colEqual) {
                return true;
            }
        }
        return false;
    }
}
