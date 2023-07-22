package model;

import java.util.Deque;
import java.util.LinkedList;

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

        System.out.println("List of Players Playing TicTocToe Game (and their Playing Pieces) are: ");
        for(Player player: players){
            System.out.println("+++===>> '" + player.getPlayerName() + "' -> "  + player.getPlayerPiece().getPieceType());
        }
        startGame(players, board);
    }

    public void startGame(Deque<Player> players, Board board){
        boolean winner = false;
        while(!winner){
            if(board.rowColumnDiagonalMatch()){

            }
        }
    }
}
