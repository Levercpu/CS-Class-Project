
public class ChessBoard {
    private static Square[][] chessBoard = new Square[8][8];

    static {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoard[i][j] = new Square(i, j);
            }
        }
    }

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
                Piece piece = chessBoard[i][j].getPiece();
                System.out.print(piece == null ? "." : piece.type);
            }
            System.out.println();
        }
    }
    public boolean attemptMove(Square from, Square to) {
        if (from == null || to == null || from.getPiece() == null) {
        return false;
        }
        Piece piece = from.getPiece();
        if (to.getOccupied() || to.getPiece().isWhite == piece.isWhite) {
            return false;
    }
        if (piece.getValidMoves().contains(to) || piece.getValidCaptures().contains(to)) {
            piece.moveTo(to);
            return true;
        }
        return false;

    }
    public static void main(String[] args) {
        // Chessboard board = new Chessboard();
        // Chessboard.printBoard();
    }
}

// hello guys

///hi guyssssss
    //     .-------.
    //   .'         '.
    //  /   o     o   \
    //        -
    // |               |
    // |    \     /    |
    //  \    '---'    /
    //   '.         .'
        // '-------'
