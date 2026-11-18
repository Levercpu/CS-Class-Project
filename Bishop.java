import java.util.ArrayList;

public class Bishop extends Piece{
    public Bishop(Square startingSquare, boolean isWhite) {
        super(startingSquare, isWhite);
    }
    @Override
    public ArrayList<Square> getValidMoves() {
        ArrayList<Square> bishopMoves = getDiagonalLines();
        return bishopMoves;
    }
}
