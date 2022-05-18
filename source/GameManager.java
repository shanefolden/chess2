import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.Arrays;

public class GameManager extends JPanel {

  private int currentGame[][];

  public void startGame() {
    ArrayList<Piece> pieces = createPieces();
    String [][]currentGame = getGameState(pieces);
    printGameState(currentGame);
  }

  private ArrayList<Piece> createPieces() {
    ArrayList<Piece> pieces = new ArrayList<Piece>();

    
    for (int i = 0; i < 8; i++) {
      pieces.add(new Pawn(6, i, true));
      pieces.add(new Pawn(1, i, false));
    }

    return pieces;
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

  
}
