import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Screen extends JPanel implements MouseListener {

  private Board board = new Board();
  private GameManager game = new GameManager();

  public Screen() {
    setBackground(new Color(230, 230, 230));
    addMouseListener(this);
  }

  public Dimension getPreferredSize() {
    //Sets the size of the panel
    return new Dimension(1200, 1000);
  }

  public void play() {
    game.startGame();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    board.drawBoard(g);
  }

  public void mousePressed(MouseEvent e) {}

  public void mouseReleased(MouseEvent e) {}

  public void mouseEntered(MouseEvent e) {}

  public void mouseExited(MouseEvent e) {}

  public void mouseClicked(MouseEvent e) {
    game.testFunction();
    int[] coords = board.getSquare(e.getX(), e.getY());
    game.getClick(coords);
  }
}
