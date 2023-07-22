package model;

public class Player {
    private String playerName;
    private PlayerPiece playerPiece;

    public Player(String playerName, PlayerPiece playerPiece) {
        this.playerName = playerName;
        this.playerPiece = playerPiece;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public PlayerPiece getPlayerPiece() {
        return playerPiece;
    }

    public void setPlayerPiece(PlayerPiece playerPiece) {
        this.playerPiece = playerPiece;
    }
}
