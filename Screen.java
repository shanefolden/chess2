import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Screen extends JPanel {

  public Dimension getPreferredSize() {
    //Sets the size of the panel
    return new Dimension(1200, 1000);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Board board = new Board(g);
    Game game = new Game();
    game.startGame(g);
  }
}
