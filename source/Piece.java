public class Piece {

  enum Clr {
    WHITE,
    BLACK,
  }

  private int[] position = new int[2];
  private final Clr color;

  // Initialize piece with x coordinate, y coordinate, and color
  public Piece(int x, int y, boolean isWhite) {
    position[0] = x;
    position[1] = y;
    if (isWhite) {
      color = Clr.WHITE;
    } else {
      color = Clr.BLACK;
    }
  }

  public int[] getPosition() {
    return position;
  }

  public String getTag() {
      if(color == Clr.WHITE) {
          return "WP";
      } else {
          return "BP";
      }
  }

  public void setPosition(int x, int y) {
    position[0] = x;
    position[1] = y;
  }

  public String toString() {
    return (
      "created at row: " +
      position[0] +
      ", col: " +
      position[1] +
      " of color: " +
      color
    );
  }
}
