import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(Square startingSquare, boolean isWhite) {
        super(startingSquare, isWhite);
    }
    String type = "Q";

    @Override
    public ArrayList<Square> getValidMoves() {
        ArrayList<Square> queenMoves = getHorizontalLine();
        queenMoves.addAll(getVerticalLine());
        queenMoves.addAll(getDiagonalLines());
        return queenMoves;
    }
}
