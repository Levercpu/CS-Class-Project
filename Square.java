public class Square {
    private Piece currentPiece;
    private boolean occupied;
    public int x;
    public int y;
    public boolean getOccupied() {
        return occupied;
    }
    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        occupied = false;
    }
    public Piece getPiece() {
        return currentPiece;
    }
    public void setPiece(Piece newPiece) {
        currentPiece = newPiece;
        occupied = (newPiece == null) ? false : true;
    }
}