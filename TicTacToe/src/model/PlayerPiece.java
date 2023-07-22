package model;

public class PlayerPiece {
    public PieceType pieceType;

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PlayerPiece(PieceType pieceType) {
        this.pieceType = pieceType;
    }
}
