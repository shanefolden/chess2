import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {

  BufferedImage buffered;
  final int ROW_WIDTH = 805;
  final int COL_HEIGHT = 805;
  final int SQUARE_LENGTH = 115;

  public Board(Graphics g) {
    drawBoard(g);
  }

  public void drawBoard(Graphics g) {
    drawLines(g);
    drawSpaces(g);
  }

  public void drawLines(Graphics g) {
    for (int i = 0; i < 8; i++) {
      int height = i == 0 || i == 7 ? 15 : 10;
      g.fillRect(100, i * 113 + 40, ROW_WIDTH, height);
    }
    // draw cols
    for (int i = 0; i < 8; i++) {
      int width = i == 0 || i == 7 ? 15 : 10;
      g.fillRect(i * 113 + 100, 40, width, COL_HEIGHT);
    }
  }

  public void drawSpaces(Graphics g) {
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        Color squareColor = (i + j) % 2 == 0
          ? new Color(50, 50, 50)
          : new Color(200, 200, 200);
        int xOffset = i == 0 || i == 7 ? 15 : 10;
        int yOffset = j == 0 || j == 7 ? 15 : 10;

        g.setColor(squareColor);
        g.fillRect(
          i * 113 + 100 + xOffset,
          j * 113 + 40 + yOffset,
          SQUARE_LENGTH - xOffset,
          SQUARE_LENGTH - yOffset
        );
      }
    }
  }
}
