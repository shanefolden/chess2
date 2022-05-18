import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameManager extends JPanel {

  private int currentGame[][];

  public void startGame() {
    ArrayList<Piece> pieces = new ArrayList<Piece>();
    pieces.add(new Pawn(0, 0, true));
    System.out.println("Arraylist size: " + pieces.size());
    System.out.println(pieces.get(0).toString());
  }
}
