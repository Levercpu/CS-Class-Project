import java.util.ArrayList;

public class Bishop extends Piece{
    public Bishop(Square startingSquare, boolean isWhite) {
        super(startingSquare, isWhite);
    }
    String type = "B";
    @Override
    public ArrayList<Square> getValidMoves() {
        ArrayList<Square> bishopMoves = getDiagonalLines();
        return bishopMoves;
    }
    
    @Override


    public ArrayList<Square> getValidCaptures() {
        return getDiagonalCaptures();
    }
}
