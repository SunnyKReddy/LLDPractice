import model.Board;
import model.PieceType;
import model.PlayerPieceO;
import model.PlayerPieceX;

public class Client {
    public static void main(String[] args) {
        PlayerPieceX playerPieceX = new PlayerPieceX(PieceType.X);
        PlayerPieceO playerPieceO = new PlayerPieceO(PieceType.O);
        System.out.println("Board initializing...");
        Board b = new Board(4);
        //b.printBoardStatus();
        b.board[0][0] = playerPieceX;
        b.board[0][1] = playerPieceO;
        b.board[0][2] = playerPieceO;
        b.board[1][1] = playerPieceO;
        b.board[2][1] = playerPieceX;
        b.board[2][1] = playerPieceX;
        b.board[0][3] = playerPieceX;
        b.board[3][0] = playerPieceX;
        b.board[1][2] = playerPieceX;
        if(b.board[2][2] == null){
            b.board[2][2] = playerPieceX;
        }
        if(b.board[2][1] == null){
            b.board[2][2] = playerPieceO;
        }else{
            System.out.println("Please place your Piece on EMPTY position (SLOT) on Board");
        }


        b.printBoardStatus();
        System.out.println(b.rowColumnDiagonalMatch());
    }
}
