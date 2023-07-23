package model;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        //Initializing list of players playing the game
        Deque<Player> players;
        Player player1 = new Player("Sunny", new PlayerPieceX());
        Player player2 = new Player("GK", new PlayerPieceO());
        players = new LinkedList<>();
        players.addLast(player1);
        players.addLast(player2);

        // Initializing Board

        Board board = new Board(3);

//        System.out.println("List of Players Playing TicTocToe Game (and their Playing Pieces) are: ");
//        for(Player player: players){
//            System.out.println("+++===>> '" + player.getPlayerName() + "' -> "  + player.getPlayerPiece().getPieceType());
//        }
        startGame(players, board);
    }

    public void startGame(Deque<Player> players, Board board){
        boolean winner = false;
        while(!winner){
            Player currentPlayer = players.removeFirst();
            System.out.println("+++ CURRENT_PLAYER ===>> '" + currentPlayer.getPlayerName() + "' -> "  + currentPlayer.getPlayerPiece().getPieceType());
            //board.printBoardStatus();
            System.out.print("Player:" + currentPlayer.getPlayerName() + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            if(board.board[inputRow][inputColumn] == null){
                board.board[inputRow][inputColumn] = currentPlayer.getPlayerPiece();
            }
            else{
                System.out.println("Position is non empty");
                continue;
            }

//            board.board[0][1] = playerPieceO;
//            board.board[0][2] = playerPieceO;
//            board.board[1][1] = playerPieceO;
//            board.board[2][1] = playerPieceX;
//            board.board[2][1] = playerPieceX;
//            board.board[0][3] = playerPieceX;
//            board.board[3][0] = playerPieceX;
//            board.board[1][2] = playerPieceX;
            board.printBoardStatus();
            if(board.rowColumnDiagonalMatch()){
                winner = true;
                System.out.println("+++ WINNER OF THE GAME IS:  ===>> '" + currentPlayer.getPlayerName() + "' -> "  + currentPlayer.getPlayerPiece().getPieceType());
                continue;
            }
            players.addLast(currentPlayer);
            if(board.checkNotNullElementsOnBoard()){
                System.out.println("Game is Tie, '''No WINNER''', .... <<<< Well Played >>>> ....");
                break;
            }
        }
    }
}
