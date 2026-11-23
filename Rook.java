import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(Square startingSquare, boolean isWhite) {
        super(startingSquare, isWhite);
        type = "R";
    }

    @Override
    public ArrayList<Square> getValidMoves() {
        ArrayList<Square> rookMoves = getHorizontalLine();
        rookMoves.addAll(getVerticalLine());
        return rookMoves;
    }

    @Override
    public ArrayList<Square> getValidCaptures() {
        ArrayList<Square> captures = getHorizontalCaptures();
        captures.addAll(getVerticalCaptures());
        return captures;
    }
}