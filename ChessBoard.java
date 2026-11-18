
public class ChessBoard {
    private static Square[][] chessBoard = new Square[8][8];
    public static boolean getSquareOccupied(int i1, int i2) {
        return chessBoard[i1][i2].getOccupied();
    }
    public static Square getSquare(int i1, int i2) {
        return chessBoard[i1][i2];
    }

    public static void main(String[] args) {
        
    }
}

// hello guys