import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(Square startingSquare, boolean isWhite) {
        super(startingSquare, isWhite);
    }
    String type = "R";
    @Override
    public ArrayList<Square> getValidMoves() {
        ArrayList<Square> rookMoves = getHorizontalLine();
        rookMoves.addAll(getVerticalLine());
        return rookMoves;
    }
}