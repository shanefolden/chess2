import javax.swing.JFrame;

public class Chess {

  public static void main(String[] args) {
    JFrame frame = new JFrame("Chess");

    Screen sc = new Screen();
    frame.add(sc);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    sc.play();
    //sc.animate();

  }
}
