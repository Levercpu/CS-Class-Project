import javax.swing.*;

public class ChessGame {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ChessBoard board = new ChessBoard();
            board.populateBoard();

            // System.out.println(board.getSquare(0, 0).getPiece());
            ChessGUI gui = new ChessGUI(board);
            gui.setResizable(false);
            gui.setVisible(true);

        });
    }
}