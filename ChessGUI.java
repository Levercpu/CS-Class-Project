import javax.swing.*;

import java.awt.*;

public class ChessGUI extends JFrame {

    private JButton[][] buttons = new JButton[8][8];

    public ChessGUI(ChessBoard board) {

        setTitle("Chess");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel chessPanel = new JPanel(new GridLayout(8, 8));

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                JButton square = new JButton();

                square.setFont(new Font("SansSerif", Font.PLAIN, 39));
                if ((row + col) % 2 == 0) {
                    square.setBackground(new Color(125, 148, 93));
                } else {
                    square.setBackground(new Color(238, 238, 213));
                }
                if (board.getSquare(row, col).getOccupied()) {

                    ImageIcon icon = new ImageIcon("src/images/pieces/missingno.png");
                    Piece piece = board.getSquare(row, col).getPiece();
                    String color = piece.isWhite ? "white" : "black";
                    String type = switch (piece.getType()) {
                        case "Q" -> "queen";
                        case "B" -> "bishop";
                        case "K" -> "king";
                        case "N" -> "knight";
                        case "R" -> "rook";
                        case "P" -> "pawn";
                        default -> "missingno";
                    };
                    icon = new ImageIcon("src/images/pieces/" + color + type + ".png");
                    square.setIcon(new ImageIcon(icon.getImage()
                            .getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
                }
                buttons[row][col] = square;
                chessPanel.add(square);
            }
        }

        add(chessPanel);

        setVisible(true);
    }

}