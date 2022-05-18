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

/*
 TERMS
GameState = whos turn it is (white or black), and whether they are currently clicking a source or desitnation piece
boardState = the current state of the board (What pieces are on the board and where)
Pieces = A list of all the pieces on the board


 */

public class GameManager extends JPanel {

  enum GameState {
    white_choose_source,
    white_choose_destination,
    black_choose_source,
    black_choose_destination,
    game_over,
  }

  private String currentBoardPosition[][];
  Board board;
  GameState gameState;
  ArrayList<Piece> pieces;

  public void startGame() {
    board = new Board();
    pieces = createPieces();
    currentBoardPosition = getBoardPosition(pieces);
    printBoardPosition(currentBoardPosition);
    gameState = GameState.white_choose_source;
  }

  private String[][] getBoardPosition(ArrayList<Piece> pieces) {
    // Generate an empty game board filled with "XX"
    String[][] newBoardPosition = new String[8][8];
    for (String[] row : newBoardPosition) Arrays.fill(row, "XX");

    // Loop through all pieces and populate the game  board with the correct tags
    for (Piece piece : pieces) {
      newBoardPosition[piece.getPosition()[0]][piece.getPosition()[1]] =
        piece.getTag();
    }

    return newBoardPosition;
  }

  private void printBoardPosition(String[][] boardPosition) {
    for (String[] row : boardPosition) {
      System.out.println(Arrays.toString(row).replace("], ", "]\n"));
    }
  }

  public void testFunction() {
    System.out.println("test");
  }

  public void getClick(int[] position) {
    if (position[0] == -1 || position[1] == -1) {
      return;
    }

    switch (gameState) {
      case white_choose_source:
        if (isValidSource('W', position)) {
          System.out.println("valid piece");
          gameState = GameState.black_choose_source;
        } else {
          System.out.println("invalid piece");
        }
        break;
      case white_choose_destination:
        //isValidDestination("W", position);
        break;
      case black_choose_source:
        if (isValidSource('B', position)) {
          System.out.println("valid piece");
          gameState = GameState.white_choose_source;
        } else {
          System.out.println("invalid piece");
        }
        break;
      case black_choose_destination:
        //isValidDestination("B", position);
        break;
      default:
        break;
    }
  }

  public boolean isValidSource(char player, int[] position) {
    System.out.println(currentBoardPosition[position[0]][position[1]]);
    return (currentBoardPosition[position[0]][position[1]].charAt(0) == player);
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
