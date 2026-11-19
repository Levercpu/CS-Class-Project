import java.util.ArrayList;

abstract public class Piece {
    Square currentlyOn;
    boolean isWhite;
    public Square[] validMoves;
    public String type;
    public abstract ArrayList<Square> getValidMoves();
    public ArrayList<Square> getValidCaptures() {
        return new ArrayList<Square>(); // TODO: just use the movement methods but only the exact squares that would break the loop~
    }
    public Piece(Square startingSquare, boolean isWhite) {
        currentlyOn = startingSquare;
        this.isWhite = isWhite;
        startingSquare.setPiece(this);
    }
    public void moveTo(Square other) {
        if (other == null || other == currentlyOn) {
            return;
        }
        if (other.getOccupied() && other.getPiece().isWhite == isWhite) {
            return;
        }
        if (other.getOccupied()) {
            other.getPiece().currentlyOn = null;
        }
        currentlyOn.setPiece(null);
        currentlyOn = other;
        other.setPiece(this);
    }
    public ArrayList<Square> getHorizontalLine() {
        ArrayList<Square> squares = new ArrayList<Square>();
        for (int i = 0; i < currentlyOn.x; i++) {
            if (ChessBoard.getSquareOccupied(i, currentlyOn.y))
                break;
            squares.add(ChessBoard.getSquare(i, currentlyOn.y));
        }
        for (int i = currentlyOn.x + 1; i < 8; i++) {
            if (ChessBoard.getSquareOccupied(i, currentlyOn.y))
                break;
            squares.add(ChessBoard.getSquare(i, currentlyOn.y));

        }
        return squares;
    }
    public ArrayList<Square> getHorizontalCaptures() {
        ArrayList<Square> captures = new ArrayList<Square>();
        captures.addAll(getCaptureLine(-1, 0));
        captures.addAll(getCaptureLine(1, 0));
        return captures;
    }
    public ArrayList<Square> getVerticalLine() {
        ArrayList<Square> squares = new ArrayList<Square>();
        for (int i = 0; i < currentlyOn.y; i++) {
            if (ChessBoard.getSquareOccupied(currentlyOn.x, i))
                break;
            squares.add(ChessBoard.getSquare(currentlyOn.x, i));
        }
        for (int i = currentlyOn.y + 1; i < 8; i++) {
            if (ChessBoard.getSquareOccupied(currentlyOn.x, i))
                break;
            squares.add(ChessBoard.getSquare(currentlyOn.x, i));
        }
        return squares;
    }
    public ArrayList<Square> getVerticalCaptures() {
        ArrayList<Square> captures = new ArrayList<Square>();
        captures.addAll(getCaptureLine(0, -1));
        captures.addAll(getCaptureLine(0, 1));
        return captures;
    }
    public ArrayList<Square> getDiagonalLines() {
        ArrayList<Square> squares = new ArrayList<Square>();
        squares.addAll(getLine(-1, -1));
        squares.addAll(getLine(-1, 1));
        squares.addAll(getLine(1, -1));
        squares.addAll(getLine(1, 1));
        return squares;
    }
    public ArrayList<Square> getDiagonalCaptures() {
        ArrayList<Square> captures = new ArrayList<Square>();
        captures.addAll(getCaptureLine(-1, -1));
        captures.addAll(getCaptureLine(-1, 1));
        captures.addAll(getCaptureLine(1, -1));
        captures.addAll(getCaptureLine(1, 1));
        return captures;
    }

    private ArrayList<Square> getLine(int dx, int dy) {
        ArrayList<Square> squares = new ArrayList<Square>();
        int x = currentlyOn.x + dx;
        int y = currentlyOn.y + dy;
        while (x >= 0 && x < 8 && y >= 0 && y < 8) {
            Square square = ChessBoard.getSquare(x, y);
            if (square.getOccupied()) {
                break;
            }
            squares.add(square);
            x += dx;
            y += dy;
        }
        return squares;
    }

    private ArrayList<Square> getCaptureLine(int dx, int dy) {
        ArrayList<Square> captures = new ArrayList<Square>();
        int x = currentlyOn.x + dx;
        int y = currentlyOn.y + dy;
        while (x >= 0 && x < 8 && y >= 0 && y < 8) {
            Square square = ChessBoard.getSquare(x, y);
            if (square.getOccupied()) {
                if (square.getPiece().isWhite != isWhite) {
                    captures.add(square);
                }
                break;
            }
            x += dx;
            y += dy;
        }
        return captures;
    }
}