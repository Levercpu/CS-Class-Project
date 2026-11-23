
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

    public void populateBoard() {
        chessBoard[0][0].setPiece(new Rook(getSquare(0, 0), false));
        // chessBoard[0][1].setPiece(new Knight(getSquare(0, 1), false));
        chessBoard[0][2].setPiece(new Bishop(getSquare(0, 2), false));
        chessBoard[0][3].setPiece(new Queen(getSquare(0, 3), false));
        // chessBoard[0][4].setPiece(new King(getSquare(0, 4), false));
        chessBoard[0][5].setPiece(new Bishop(getSquare(0, 5), false));
        // chessBoard[0][6].setPiece(new Knight(getSquare(0, 6), false));
        chessBoard[0][7].setPiece(new Rook(getSquare(0, 7), false));

        // for (int col = 0; col < 8; col++) {
        // chessBoard[1][col].setPiece(new Pawn(getSquare(1, col), false));
        // }

        // for (int col = 0; col < 8; col++) {
        // chessBoard[6][col].setPiece(new Pawn(getSquare(6, col), true));
        // }

        // White back row
        chessBoard[7][0].setPiece(new Rook(getSquare(7, 0), true));
        // chessBoard[7][1].setPiece(new Knight(getSquare(7, 1), true));
        chessBoard[7][2].setPiece(new Bishop(getSquare(7, 2), true));
        chessBoard[7][3].setPiece(new Queen(getSquare(7, 3), true));
        // chessBoard[7][4].setPiece(new King(getSquare(7, 4), true));
        chessBoard[7][5].setPiece(new Bishop(getSquare(7, 5), true));
        // chessBoard[7][6].setPiece(new Knight(getSquare(7, 6), true));
        chessBoard[7][7].setPiece(new Rook(getSquare(7, 7), true));
    }
}
