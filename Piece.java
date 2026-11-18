import java.util.ArrayList;

abstract public class Piece {
    Square currentlyOn;
    boolean isWhite;
    public Square[] validMoves;
    public abstract ArrayList<Square> getValidMoves();
    public Piece(Square startingSquare, boolean isWhite) {
        currentlyOn = startingSquare;
        this.isWhite = isWhite;
    }
    public ArrayList<Square> getHorizontalLine() {
        ArrayList<Square> squares = new ArrayList<Square>();
        for (int i = 0; i < 8; i++) {
            if (!ChessBoard.getSquareOccupied(i, currentlyOn.y)) {
                squares.add(ChessBoard.getSquare(i, currentlyOn.y));
            }
        }
        return squares;
    }
    public ArrayList<Square> getVerticalLine() {
        ArrayList<Square> squares = new ArrayList<Square>();
        for (int i = 0; i < 8; i++) {
            if (!ChessBoard.getSquareOccupied(currentlyOn.x, i)) {
                squares.add(ChessBoard.getSquare(currentlyOn.x, i));
            }
        }
        return squares;
    }
    public ArrayList<Square> getDiagonalLines() {
        ArrayList<Square> squares = new ArrayList<Square>();
        int rightBoundary = 8 - currentlyOn.x;
        int leftBoundary = currentlyOn.x;
        int topBoundary = 8 - currentlyOn.y;
        int bottomBoundary = currentlyOn.y;
        // you could loop over every square in the chessboard and run an if to do it easier, but I wanted to be precise

        for (int i = 0; i < Math.min(rightBoundary, topBoundary); i++) {
            squares.add(ChessBoard.getSquare(currentlyOn.x + i, currentlyOn.y + i));
        }
        for (int i = 0; i < Math.min(leftBoundary, topBoundary); i++) {
            squares.add(ChessBoard.getSquare(currentlyOn.x - i, currentlyOn.y + i));
        }
        for (int i = 0; i < Math.min(leftBoundary, bottomBoundary); i++) {
            squares.add(ChessBoard.getSquare(currentlyOn.x - i, currentlyOn.y - i));
        }
        for (int i = 0; i < Math.min(rightBoundary, bottomBoundary); i++) {
            squares.add(ChessBoard.getSquare(currentlyOn.x + i, currentlyOn.y - i));
        }
        return squares;
    }
}