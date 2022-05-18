import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {

  private final int ROW_WIDTH = 918;
  private final int COL_HEIGHT = 918;
  private final int SQUARE_LENGTH = 113;

  public void drawBoard(Graphics g) {
    drawEdges(g);
    fillSquares(g);
  }

  public void drawEdges(Graphics g) {
    for (int i = 0; i < 9; i++) {
      int height = i == 0 || i == 8 ? 15 : 10;
      g.fillRect(100, i * SQUARE_LENGTH + 40, ROW_WIDTH, height);
    }
    // draw cols
    for (int i = 0; i < 9; i++) {
      int width = i == 0 || i == 8 ? 15 : 10;
      g.fillRect(i * SQUARE_LENGTH + 100, 40, width, COL_HEIGHT);
    }
  }

  public void fillSquares(Graphics g) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        Color squareColor = (i + j) % 2 == 0
          ? new Color(200, 200, 200) // white
          : new Color(50, 50, 50); // black
        int xOffset = i == 0 || i == 8 ? 15 : 10;
        int yOffset = j == 0 || j == 8 ? 15 : 10;

        g.setColor(squareColor);
        g.fillRect(
          i * SQUARE_LENGTH + 100 + xOffset,
          j * SQUARE_LENGTH + 40 + yOffset,
          SQUARE_LENGTH - xOffset,
          SQUARE_LENGTH - yOffset
        );
      }
    }
  }

  public int[] getSquare(int x, int y) {
    int xMin;
    int xMax;
    int yMin;
    int yMax;

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        int xOffset = i == 0 || i == 8 ? 15 : 10;
        int yOffset = j == 0 || j == 8 ? 15 : 10;

        xMin = i * SQUARE_LENGTH + 100 + xOffset;
        xMax = i * SQUARE_LENGTH + 100 + SQUARE_LENGTH - xOffset;
        yMin = j * SQUARE_LENGTH + 40 + yOffset;
        yMax = j * SQUARE_LENGTH + 40 + SQUARE_LENGTH - yOffset;

        if (x >= xMin && x <= xMax && y >= yMin && y <= yMax) {
          return new int[] { j, i };
        }
      }
    }
    return new int[] { -1, -1 };
  }
}
