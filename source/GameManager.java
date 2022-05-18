import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameManager extends JPanel {

  private int currentGame[][];

  public void startGame() {
    ArrayList<Piece> pieces = createPieces();
    String[][] currentGame = getGameState(pieces);
    printGameState(currentGame);
  }

  // Function to get the state of the game board in string form
  private String[][] getGameState(ArrayList<Piece> pieces) {
    // Generate an empty game board filled with "XX"
    String[][] gameState = new String[8][8];
    for (String[] row : gameState) Arrays.fill(row, "XX");

    // Loop through all pieces and populate the game  board with the correct tags
    for (Piece piece : pieces) {
      gameState[piece.getPosition()[0]][piece.getPosition()[1]] =
        piece.getTag();
    }

    return gameState;
  }

  private void printGameState(String[][] gameState) {
    for (String[] row : gameState) {
      System.out.println(Arrays.toString(row).replace("], ", "]\n"));
    }
  }

  private ArrayList<Piece> createPieces() {
    ArrayList<Piece> pieces = new ArrayList<Piece>();

    for (int i = 0; i < 8; i++) {
      pieces.add(new Pawn(6, i, true));
      pieces.add(new Pawn(1, i, false));
    }

    pieces.add(new Rook(0, 0, false));
    pieces.add(new Rook(0, 7, false));
    pieces.add(new Rook(7, 0, true));
    pieces.add(new Rook(7, 7, true));
    pieces.add(new Knight(0, 1, false));
    pieces.add(new Knight(0, 6, false));
    pieces.add(new Knight(7, 1, true));
    pieces.add(new Knight(7, 6, true));
    pieces.add(new Bishop(0, 2, false));
    pieces.add(new Bishop(0, 5, false));
    pieces.add(new Bishop(7, 2, true));
    pieces.add(new Bishop(7, 5, true));
    pieces.add(new Queen(0, 3, false));
    pieces.add(new Queen(7, 3, true));
    pieces.add(new King(0, 4, false));
    pieces.add(new King(7, 4, true));

    return pieces;
  }
}
