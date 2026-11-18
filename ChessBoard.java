
public class ChessBoard {
    private static Square[][] chessBoard = new Square[8][8];
    public static boolean getSquareOccupied(int i1, int i2) {
        return chessBoard[i1][i2].getOccupied();
    }
    public static Square getSquare(int i1, int i2) {
        return chessBoard[i1][i2];
    }
    // default
    ChessBoard() {

    }
    public void printBoard() {
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                System.out.print(chessBoard[i][j].getPiece().type);
            }
            System.out.println();
        }
    }
    public boolean attemptMove(Square from, Square to) {
        if (from.getPiece().getValidMoves().contains(to)) {
            from.getPiece().moveTo(to);
            return true;
        }
        return false;

    }
    public static void main(String[] args) {
        
    }
}

// hello guys