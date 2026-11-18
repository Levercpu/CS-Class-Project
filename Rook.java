import java.util.ArrayList;

public class Rook extends Piece {
    public Square[] validMoves (){
        ArrayList<Square> possibleMoves = new ArrayList<Square>();
        for (int x=currentlyOn.x+1;x<8; x++) {
            int y = currentlyOn.y;
            if (ChessBoard.getSquareOccupied(x,y)) {
                break;
            } else {
                possibleMoves.add(ChessBoard.getSquare(x,y));
            }
        }
        for (int x=currentlyOn.x-1;x>=0; x--) {
            int y = currentlyOn.y;
            if (ChessBoard.getSquareOccupied(x,y)) {
                break;
            } else {
                possibleMoves.add(ChessBoard.getSquare(x,y));
            }
        }
        for (int y=currentlyOn.y+1;y<8; y++) {
            int x = currentlyOn.x;
            if (ChessBoard.getSquareOccupied(x,y)) {
                break;
            } else {
                possibleMoves.add(ChessBoard.getSquare(x,y));
            }
        }
        for (int y=currentlyOn.y-1;y>=0; y--) {
            int x = currentlyOn.x;
            if (ChessBoard.getSquareOccupied(x,y)) {
                break;
            } else {
                possibleMoves.add(ChessBoard.getSquare(x,y));
            }
        }
        return possibleMoves.toArray(new Square[0]);
    }
}